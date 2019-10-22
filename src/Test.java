
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {

    public static void main(String[] args){
        Pattern compile = Pattern.compile("(0|[0-4]{2})?[0][3][0-9]{9}");
        Matcher matcher = compile.matcher("0303003115234");
        while (matcher.find()) {            
            System.out.println(matcher.group());
        }
//        try {
//            Workbook workbook=WorkbookFactory.create(new FileInputStream(new File("file.xlsx")));
//            Sheet sheet=workbook.getSheetAt(0);
//            
//            int firstRowNum=sheet.getFirstRowNum();
//            int lastRowNum=sheet.getLastRowNum();
//            for (int i = firstRowNum; i <= lastRowNum; i++) {
//                Row row = sheet.getRow(i);
//                
//                if (i==0) {
//                    for (int j = 0; j < row.getLastCellNum(); j++) {
//                        String value = row.getCell(j).getStringCellValue();
//                        int index=0;
//                        if (index++==j && !value.equals("Accession No")) {
//                            throw new RuntimeException("Accession No Not Found");
//                        }else if (index++==j  && !value.equals("Location")) {
//                            throw new RuntimeException("Location");
//                        }else if (index++==j  && !value.equals("issue limit")) {
//                            throw new RuntimeException("issue limit");
//                        }else if (index++==j  && !value.equals("title")) {
//                            throw new RuntimeException("title");
//                        }else if (index++==j  && !value.equals("author")) {
//                            throw new RuntimeException("author");
//                        }else if (index++==j  && !value.equals("category")) {
//                            throw new RuntimeException("category");
//                        }else if (index++==j  && !value.equals("publisher")) {
//                            throw new RuntimeException("publisher");
//                        }else if (index++==j  && !value.equals("publishing date")) {
//                            throw new RuntimeException("publishing date");
//                        }else if (index++==j  && !value.equals("isbn")) {
//                            throw new RuntimeException("isbn");
//                        }else if (index++==j  && !value.equals("pages")) {
//                            throw new RuntimeException("pages");
//                        }
//                    }
//                }else{
//                    int accessionNo=(int)row.getCell(0).getNumericCellValue();
//                    String locString=row.getCell(1).getStringCellValue();
//                    int issueLimit=(int)row.getCell(2).getNumericCellValue();
//                    String title=row.getCell(3).getStringCellValue();
//                    String author=row.getCell(4).getStringCellValue();
//                    String category=row.getCell(5).getStringCellValue();
//                    String publisher=row.getCell(6).getStringCellValue();
//                    Date publishingDate=row.getCell(7).getDateCellValue();
//                    double isbn=row.getCell(8).getNumericCellValue();
//                    int pages=(int)row.getCell(9).getNumericCellValue();
//                    Books book = new Books(accessionNo, locString, issueLimit, title, author, category, publisher, new java.sql.Date(publishingDate.getTime()), String.valueOf(isbn), pages,null);
//                }
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
