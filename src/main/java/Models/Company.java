package Models;

public class Company{
    private int Id;
    private String companyName;
    private double ratingCompany;

    public Company(int id, String company, double rating ){
        this.Id = id;
        this.companyName = company;
        this.ratingCompany = rating;
    }

    public int getCompanyId() {
        return Id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getRatingCompany() {
        return ratingCompany;
    }

    @Override
    public String toString() {
        return "Company: {" +
                "Id=" + Id +
                ", companyName='" + companyName + '\'' +
                ", ratingCompany=" + ratingCompany +
                '}';
    }
}
