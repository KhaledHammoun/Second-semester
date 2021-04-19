package Ex2_Person_Storage;

public class Person
{
    private String name;
    private String DOB;
    private int ssn;

    public Person(String name, String DOB, int ssn)
    {
        this.name = name;
        this.DOB = DOB;
        this.ssn = ssn;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDOB()
    {
        return DOB;
    }

    public void setDOB(String DOB)
    {
        this.DOB = DOB;
    }

    public int getSsn()
    {
        return ssn;
    }

    public void setSsn(int ssn)
    {
        this.ssn = ssn;
    }

    @Override
    public String toString()
    {
        return "Person: " + "name='" + name + '\'' + ", DOB='" + DOB + '\'' + ", ssn=" + ssn + '}';
    }
}
