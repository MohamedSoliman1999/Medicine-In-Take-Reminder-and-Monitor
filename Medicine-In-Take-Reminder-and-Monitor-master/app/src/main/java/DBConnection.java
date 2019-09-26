import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnection extends SQLiteOpenHelper {
public static String DBName="MedicineReminder";
String UserTable="CREATE TABLE IF NOT EXISTS user"+
         "(name INTEGER NOT NULL , Age INTEGER , "+"gender TEXT , id INTEGER , PRIMARY  KEY(id));";
String MedicineTable="CREATE TABLE IF NOT EXISTS medicine ("+
            "id INTEGER,"+
            "name	TEXT NOT NULL,"+
            "kind	TEXT NOT NULL,"+
            "startTime	TEXT NOT NULL,"+
            "duration	REAL,"+
            "endDate	TEXT,"+
            "dosage	  REAL,"+
            "dosageUnit	TEXT,"+
            "image BLOB,"+
            "note TEXT,"+
            "stock	REAL,"+
            "minmumStock	INTEGER,"+
            "acountId	INTEGER NOT NULL,"+
            "dayInWeak	TEXT,"+
            "dateOfChangeDosage 	TEXT, PRIMARY KEY(id)," +
        "FOREIGN KEY(acountId) REFERENCES user(id) ON DELETE SET NULL);";
String ArchiveTable="CREATE TABLE IF NOT EXISTS Archive (" +
        "time TEXT," +
        "note TEXT," +
        "medicineID INTEGER," +
        "userId INTEGER," +
        "take INTEGER," +
        "intime INTEGER," +
        "FOREIGN KEY(medicineID) REFERENCES medicine(id) ON DELETE SET NULL," +
        "FOREIGN KEY(userId) REFERENCES user(id) ON DELETE SET NULL);";
String Days="CREATE TABLE IF NOT EXISTS Days (" +
        "Date TEXT," +
        "medisineId INTEGER," +
        "FOREIGN KEY(medisineId) REFERENCES medicine(id) ON DELETE SET NULL" +
        ");";
String Time="CREATE TABLE IF NOT EXISTS Time_hours (" +
        "time TEXT," +
        "medicineId INTEGER," +
        "alarm_id INTEGER"+
        ");";
    public DBConnection(Context context) {
        super(context,DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(UserTable);
        sqLiteDatabase.execSQL(MedicineTable);
        sqLiteDatabase.execSQL(Days);
        sqLiteDatabase.execSQL(Time);
        sqLiteDatabase.execSQL(ArchiveTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL("Drop table if exists user");
        sqLiteDatabase.execSQL("Drop table if exists user");
        sqLiteDatabase.execSQL("Drop table if exists Days");
        sqLiteDatabase.execSQL("Drop table if exists Archive");
        sqLiteDatabase.execSQL("Drop table if exists Time_hourse");
        sqLiteDatabase.execSQL("Drop table if exists medicine");
onCreate(sqLiteDatabase);
    }
}
