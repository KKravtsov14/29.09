import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {

    private ArrayList<Record> phones = new ArrayList<>();

    public ArrayList<Record> getAllRecords(){
        return this.phones;
    }

    public void createRecord(Record record) throws PhoneNumberAlreadyExists {
        for(Record countRecord: phones){
            if(record.getPhoneNumber().equals(countRecord.getPhoneNumber())) {
                throw new PhoneNumberAlreadyExists("Этот номер телефона уже существует");
            }
        }
        this.phones.add(record);
    }

    public void deleteRecord(long id) throws RecordNotFound {
        int flag = 0;
        for(Record countRecord: phones) {
            if (countRecord.getId() == id) {;
                phones.remove(countRecord);
                return;
            }
        }

        throw new RecordNotFound("Не существующий номер");

    }

    public void updateRecord(Record record) throws RecordNotFound, RecordNotValid {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a number:");
        String number = input.nextLine();

        if(number == null || number.isBlank()) {
            throw new RecordNotValid("Не заполнен номер телефона");
        }

        System.out.println("Input a name:");
        String name = input.nextLine();

        if(name == null || name == "") {
            throw new RecordNotValid("Не заполнено имя");
        }

        int counter = 0;
        int flag = 0;
        for(Record countRecord: phones){



            if( (int) countRecord.getId() == (int) record.getId()){
                countRecord.setPhoneNumber(number);
                countRecord.setName(name);
                flag++;
            }
            counter++;
        }

        if (flag == 0) {
            throw new RecordNotFound("Не существующий номер");
        }
    }

}
