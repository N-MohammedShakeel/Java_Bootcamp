package Java_Bootcamp.OOP.Encapsulation;

class FaceBook {
    private String username;
    private String password;
    private long phno;


    FaceBook(String username,String password,long phno){
        this.username=username;
        this.password=password;
        setPhone(phno);
    }

    void setPhone (long phno){
        this.phno=phno;
    }

    long getPhone(String username,String password){
        if(this.username == username&&this.password == password){
            return phno;
        }
        else{
            System.out.println("Invalid Credential");
        }
        return 0;
    }
}