import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {

    private ArrayList<Record> phones = new ArrayList<>();

    PhoneBook(){

    }

    public ArrayList<Record> getAllRecords(){
        return this.phones;
    }

    public void createRecord(Record record) throws PhoneNumberAlreadyExists {
        for(Record countRecord: phones){
            if(record.getPhoneNumber() == countRecord.getPhoneNumber()) {
                throw new PhoneNumberAlreadyExists("Этот номер телефона уже существует");
            }
        }
        this.phones.add(record);
    }

    public void deleteRecord(long id) throws RecordNotFound {
        int counter = 0;
        for(Record countRecord: phones) {
            if (countRecord.getId() == id) {;
                phones.remove(countRecord);
            }
            counter++;
        }
        if (counter == phones.size()) throw new RecordNotFound("Не существующий номер");
    }

    public void updateRecord(Record record) throws RecordNotFound, RecordNotValid {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a number:");
        String number = input.nextLine();

        if(number == null || number == "") {
            throw new RecordNotValid("Не заполнен номер телефона");
        }

        System.out.print("Input a name: ");
        String name = input.nextLine();

        if(name == null || name == "") {
            throw new RecordNotValid("Не заполнено имя");
        }

        int counter = 0;
        for(Record countRecord: phones){
            if(countRecord.getId() == record.getId()){
                countRecord.setPhoneNumber(number);
                countRecord.setName(name);
            }
            counter++;
        }
        if (counter == phones.size()) throw new RecordNotFound("Не существующий номер");
    }

}
