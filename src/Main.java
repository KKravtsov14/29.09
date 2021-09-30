public class Main {

    public static void main(String[] args) throws RecordNotFound, RecordNotValid, PhoneNumberAlreadyExists {
        Record name1 = new Record(1, "333", "name1");
        Record name2 = new Record(2, "88888888888", "name2");
        Record name3 = new Record(3, "88999999999", "name3");
        Record name4 = new Record(4, "99888888888", "name4");

        PhoneBook book = new PhoneBook();
        try {
            book.createRecord(name1);
            book.createRecord(name2);
            book.createRecord(name3);
            book.createRecord(name4);
        }
        catch(PhoneNumberAlreadyExists exctend){
            System.out.println(exctend.getMessage());
            throw exctend;
        }

        System.out.println(book.getAllRecords());

        try
        {
            book.updateRecord(name1);
        }
        catch(RecordNotValid exctend)
        {
            System.out.println(exctend.getMessage());
            throw exctend;
        }

        System.out.println(book.getAllRecords());

        book.deleteRecord(5);
        System.out.println(book.getAllRecords());
    }

}
