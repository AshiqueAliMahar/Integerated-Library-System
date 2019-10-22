/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google.Books;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import BeanClasses.Books;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class OnlineBookData {

    private JSONObject getJson(long isbn) {
        JSONObject jObject = null;
        try {

            //https://www.googleapis.com/books/v1/volumes?q=isbn:
            URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=isbn:" + java.net.URLEncoder.encode(isbn + "", "UTF-8"));
            HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
            urlCon.setRequestMethod("GET");
            urlCon.setRequestProperty("ACCEPT", "application/json");

            if (urlCon.getResponseCode() == 200) {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));

                String temp = "";
                StringBuilder output = new StringBuilder("");
                    
                while ((temp = bufferedReader.readLine()) != null) {
                    output.append(temp);
                }
                
                jObject = new JSONObject(output.toString());
                
                return jObject;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return jObject;
    }

    public Books setJsonData(long isbn) throws MalformedURLException {

        Books book = new Books();
        book.setPic(new byte[0]);
        try {
            JSONObject jsonObject = getJson(isbn);

            if (!jsonObject.isNull("items")) {
                String isbnNo = "";
                String title = "";
                String url = "";
                Integer pages = 0;
                String publicationDate = "";
                JSONObject volumeInfoJsonObject = jsonObject.getJSONArray("items").getJSONObject(0).getJSONObject("volumeInfo");

                if (!volumeInfoJsonObject.isNull("title")) {
                    title = volumeInfoJsonObject.getString("title");
                }
                if (!volumeInfoJsonObject.isNull("industryIdentifiers") && !volumeInfoJsonObject.getJSONArray("industryIdentifiers").getJSONObject(1).isNull("identifier")) {
                    isbnNo = volumeInfoJsonObject.getJSONArray("industryIdentifiers").getJSONObject(1).getString("identifier");
                }
                if (!volumeInfoJsonObject.isNull("authors")) {
                    JSONArray jsonAuthors = volumeInfoJsonObject.getJSONArray("authors");
                    book.setBookAuthorString(array2Str(jsonAuthors));
                }

                if (!volumeInfoJsonObject.isNull("publisher")) {
                    book.setBookPublisherString(volumeInfoJsonObject.getString("publisher"));
                }

                if (!volumeInfoJsonObject.isNull("publishedDate")) {
                    publicationDate = volumeInfoJsonObject.getString("publishedDate");
                    if (publicationDate.length() == 4) {
                        book.setBookPublishingDate(Date.valueOf(LocalDate.of(Integer.valueOf(publicationDate), 1, 1)));
                    } else {
                        book.setBookPublishingDate(Date.valueOf(publicationDate));
                    }

                }

                if (!volumeInfoJsonObject.isNull("pageCount")) {
                    pages = volumeInfoJsonObject.getInt("pageCount");
                }
                book.setIsbn(isbnNo);
                book.setBookNameString(title);
                book.setPages(pages);
                
                if (!volumeInfoJsonObject.isNull("imageLinks") && !volumeInfoJsonObject.getJSONObject("imageLinks").isNull("thumbnail")) {
                    url = volumeInfoJsonObject.getJSONObject("imageLinks").getString("thumbnail");

                    File file = new File("f.jpg");
                    file.deleteOnExit();
                    FileInputStream fileInputStream = null;
                    try {
                        System.out.println(url.toString());
                        org.apache.commons.io.FileUtils.copyURLToFile(new URL(url), file);
                        fileInputStream = new FileInputStream(file);
                        byte[] image = new byte[fileInputStream.available()];
                        fileInputStream.read(image);
                        book.setPic(image);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return book;
    }

    private String array2Str(JSONArray arr) {
        String msg = "";
        for (int i = 0; i < arr.length(); i++) {
            try {
                msg += arr.getString(i);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (arr.length() - 1 == i) {
                continue;
            } else {
                msg += ",";
            }
        }
        return msg;
    }
}
