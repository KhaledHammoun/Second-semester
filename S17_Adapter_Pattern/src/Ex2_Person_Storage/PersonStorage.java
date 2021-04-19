package Ex2_Person_Storage;

public interface PersonStorage
{
    void addPerson(Person person);
    Person getPerson(int ssn);
}
