package www.math.uni.lodz.pl.myapplication;

/**
 * Created by Relena on 31.12.2017.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Class that wraps the most common database operations. This example assumes you want a single table and data entity
 * with two properties: a category and a path as an integer. Modify in all relevant locations if you need other/more
 * properties for your data and/or additional tables.
 */
public class SimpleDatabaseHelper {
    private SQLiteOpenHelper _openHelper;

    /**
     * Construct a new database helper object
     * @param context The current context for the application or activity
     */
    public SimpleDatabaseHelper(Context context) {
        _openHelper = new SimpleSQLiteOpenHelper(context);
    }

    /**
     * This is an internal class that handles the creation of all database tables
     */
    class SimpleSQLiteOpenHelper extends SQLiteOpenHelper {
        SimpleSQLiteOpenHelper(Context context) {
            super(context, "database.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table MyTable (_id integer primary key autoincrement, category text, path text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /**
     * Return a cursor object with all rows in the table.
     * @return A cursor suitable for use in a SimpleCursorAdapter
     */
    public Cursor getAll() {
        SQLiteDatabase db = _openHelper.getReadableDatabase();
        if (db == null) {
            return null;
        }
        return db.rawQuery("select * from MyTable order by _id", null);
    }

    /**
     * Return values for a single row with the specified id
     * @param id The unique id for the row o fetch
     * @return All column values are stored as properties in the ContentValues object
     */
    public ContentValues get(long id) {
        SQLiteDatabase db = _openHelper.getReadableDatabase();
        if (db == null) {
            return null;
        }
        ContentValues row = new ContentValues();
        Cursor cur = db.rawQuery("select category, path from MyTable where _id = ?", new String[] { String.valueOf(id) });
        if (cur.moveToNext()) {
            row.put("category", cur.getString(0));
            row.put("path", cur.getString(1));
        }
        cur.close();
        db.close();
        return row;
    }

    /**
     * Add a new row to the database table
     * @param category The category value for the new row
     * @param path The path value for the new row
     * @return The unique id of the newly added row
     */
    public long add(String category, String path) {
        SQLiteDatabase db = _openHelper.getWritableDatabase();
        if (db == null) {
            return 0;
        }
        ContentValues row = new ContentValues();
        row.put("category", category);
        row.put("path", path);
        long id = db.insert("MyTable", null, row);
        db.close();
        return id;
    }

    /**
     * Delete the specified row from the database table. For simplicity reasons, nothing happens if
     * this operation fails.
     * @param id The unique id for the row to delete
     */
    public void delete(long id) {
        SQLiteDatabase db = _openHelper.getWritableDatabase();
        if (db == null) {
            return;
        }
        db.delete("MyTable", "_id = ?", new String[] { String.valueOf(id) });
        db.close();
    }

    /**
     * Updates a row in the database table with new column values, without changing the unique id of the row.
     * For simplicity reasons, nothing happens if this operation fails.
     * @param id The unique id of the row to update
     * @param category The new category value
     * @param path The new path value
     */
    public void update(long id, String category, String path) {
        SQLiteDatabase db = _openHelper.getWritableDatabase();
        if (db == null) {
            return;
        }
        ContentValues row = new ContentValues();
        row.put("category", category);
        row.put("path", path);
        db.update("MyTable", row, "_id = ?", new String[] { String.valueOf(id) } );
        db.close();
    }
}
