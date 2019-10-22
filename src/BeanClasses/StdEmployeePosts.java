package BeanClasses;

public class StdEmployeePosts {
    
    private  String postName;
    
    public StdEmployeePosts() {
        
    }
    public StdEmployeePosts(String postName) {
        this.postName = postName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
    @Override
    public String toString(){
        return postName;
    }
}
