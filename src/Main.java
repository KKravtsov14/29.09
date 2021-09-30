public class Main {

    public static void main(String[] args) throws RecordNotFound, RecordNotValid, PhoneNumberAlreadyExists {
        Record phone1 = new Record(1, "9999", "name1");
        Record phone2 = new Record(2, "8888", "name2");
        Record phone3 = new Record(3, "8899", "name2");
        Record phone4 = new Record(4, "9999", "name4");

        PhoneBook book = new PhoneBook();
        try {
            book.createRecord(phone1);
            book.createRecord(phone2);
            book.createRecord(phone3);
            book.createRecord(phone4);
        }
        catch(PhoneNumberAlreadyExists exctend){
            System.out.println(exctend.getMessage());
            throw exctend;
        }

        System.out.println(book.getAllRecords());

        try {
            book.updateRecord(phone1);
        }
        catch(RecordNotValid exctend){
            System.out.println(exctend.getMessage());
            throw exctend;
        }

        System.out.println(book.getAllRecords());

        book.deleteRecord(5);
        System.out.println(book.getAllRecords());
    }

}
