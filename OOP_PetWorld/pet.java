    
    //owner;
    //Vaccine[];
    private vaccine[] vaccine;
    private int vaccineCount;
    public pet(String name, int ID, String gender) {
        this.name = name;
        this.ID = ID;
//        this.gender = gender;
        this.setGender(gender);
        vaccine = new vaccine[100];
        vaccineCount = 0;
    }
public int vaccinate(vaccine v){
    vaccine[vaccineCount] = v;
    vaccineCount++;
    return vaccineCount;
}

    public int getVaccineCount() {
        return vaccineCount;
    }
    
    
    public void showAllPreventDisease(){
        for(int i  =0; i < vaccineCount;i++){
            System.out.println(vaccine[i].getPreventedDisease());
        }
    }

    public void setGender(String gender) {
        if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")){
          this.gender = gender;  
        }
        else{
            System.out.println("Amimals gender are only male or female");
            this.gender = "unknown";
        }
        
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public boolean setType(String type) {
        String[] typeList = {"dog","cat","fish","rabbit","bird","chicken","python","raptor","worm","cricket"};
        for(int i = 0; i < typeList.length;i++){
            if(type.equalsIgnoreCase(typeList[i])){
                this.type = type;
                        return true;
            }
        }
        //if the code is here, type parameter
        //is not in the typeList
        this.type = "unknown";
        return false;
    }

}
