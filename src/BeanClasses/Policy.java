package BeanClasses;

public class Policy {
    
    private policies policyName;
    private String policyVal;
    public static enum policies{PENALTY_PER_DAY,NO_OF_BOOK_RESERVATION,NO_OF_BOOK_ISSUE,BOOK_RESERVATION_EXPIRE_AFTER};

    public policies getPolicyName() {
        return policyName;
    }

    public void setPolicyName(policies policyName) {
        this.policyName = policyName;
    }
    public void setPolicyName(String policyName) {
        for (policies value : policies.values()) {
          if (value.toString().equals(policyName)) {
              this.policyName = value;
            }  
        }
    }
    public String getPolicyVal() {
        return policyVal;
    }

    public void setPolicyVal(String policyVal) {
        this.policyVal = policyVal;
    }
    
}
