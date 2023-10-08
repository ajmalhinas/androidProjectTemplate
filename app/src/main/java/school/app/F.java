package school.app;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;

import com.androix.AbstractMainActivity;
import com.androix.NPersistence;
import com.androix.NResultSet;
import com.androix.NTransaction;
import com.androix.SQLBuilder;
import com.androix.model.Identifiable;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

/**
 * static methods which have dependency on application code.
 */
public class F {
    private static Activity mainActivity = null;

    public static void init(Activity mainActivity) {
        F.mainActivity = mainActivity;
    }

    public static <T extends Identifiable> T find(Class<T> clazz, Long id) {
        try {
            return NPersistence.find(clazz, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * A convenient method to find by id. If the id is set to the entity.
     *
     * @param o
     * @param <T>
     * @return
     * @throws SQLException
     */
    public static <T extends Identifiable> T findById(T o) throws SQLException {
        return NPersistence.findById(o);
    }

    /**
     * Find first entity which matches with the passed partially set entity.
     * Null properties are ignored.
     *
     * @param o partially set entity
     * @return
     * @throws SQLException
     */
    public static <T extends Identifiable> T find(T o) throws SQLException {
        return NPersistence.find(o);
    }


    /**
     * Find all entities which matches with the passed partially set entity.
     * Null properties are ignored.
     *
     * @param o partially set entity
     * @return
     * @throws SQLException
     */
    public static <T extends Identifiable> List<T> findAll(T o) throws SQLException {
        return NPersistence.findAll(o);
    }


    public static <T extends Identifiable> List<T> retriveAll(Class<T> clazz) throws SQLException {
        return NPersistence.retrieveAll(clazz);
    }

    /**
     * A convenient method to retrieve raw sql result which cannot be mapped easily to any entity
     */
    public static NResultSet retrieve(SQLBuilder sqlb) {
        return NPersistence.retrieve(sqlb.getStatement());
    }

    /**
     * For all most all type of manipulation of models, other methods
     * which accept models as parameters are sufficient. This method
     * is provided in order to facilitate operation such as reading db structure.
     * E.g. SHOW TABLES;
     *
     * @param sqlb
     */
    public static Cursor executeReadStatement(SQLBuilder sqlb) {
        return NPersistence.executeReadStatement(sqlb.getStatement());
    }

    public static void persist(Identifiable o) {
        NTransaction trans = NPersistence.getTransaction();
        trans.persist(o);
    }

    /**
     * Update an existing object
     */

    public static void update(Identifiable o) {
        NTransaction trans = NPersistence.getTransaction();
        trans.update(o);
    }


    /**
     * delete a single entity from db CAUTION: A cascade operation may delete
     * multiple related entities *
     *
     * @param o object to remove
     */

    public static void remove(Identifiable o) {
        NTransaction trans = NPersistence.getTransaction();
        trans.remove(o);
    }


    /**
     * Do not use this method in actions instead use a SaveAction.
     * SaveAction will automatically commit the transaction.
     */

    public static void commit() {
        NPersistence.getTransaction().commit();
    }


    /**
     * A convenient method to get date with 00 hours morning. Java always use
     * timestamp for dates. So it is very dificult to get date only.
     *
     * @param dat
     * @return
     */
    public static Date getDatZeroHours(Date dat) {
        Calendar c = Calendar.getInstance();
        c.setTime(dat);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return c.getTime();
    }

    public static String getCurrentTimeStampString() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sf.format(new Date());
    }

    /**
     * return a yyyy-MM-dd hh:mm:ss formatted time stamp string from passed Date
     * object
     *
     * @param d
     * @return
     */
    public static String formatTimeStamp(Date d) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sf.format(d);
    }


    public static String currencyFormat(BigDecimal value) {
        NumberFormat nf;
        nf = NumberFormat.getInstance(new Locale("jk", "JK", ""));
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        nf.setGroupingUsed(false);
        return nf.format(value);

    }

    public static String currencyFormatGrouping(Long value) {
        NumberFormat nf;
        nf = NumberFormat.getInstance(new Locale("jk", "JK", ""));
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        nf.setGroupingUsed(true); // with comma separator
        return nf.format(value);

    }






    /**
     * Use this method when using the data require removing it from the app context
     *
     * @param key
     * @return
     */
    public static Object removeFromAppContext(String key) {
        return AbstractMainActivity.removeFromAppContext(key);
    }

    /**
     * Use this method when data live beyond this call
     *
     * @param key
     * @return
     */
    public static Object getFromAppContext(String key) {
        return AbstractMainActivity.getFromAppContext(key);
    }

    /**
     * Use this method when data live beyond this call
     *
     * @param key
     * @return
     */
    public static void putToAppContext(String key, Object data) {
        AbstractMainActivity.putToAppContext(key, data);
    }
    public static String getFromSharedPreferences(String key) {
        SharedPreferences shp = mainActivity.getSharedPreferences("myPreferences", MODE_PRIVATE);
        return shp.getString(key, null);
    }
    public static void putToSharedPreferences(String key, String value) {
        SharedPreferences shp = mainActivity.getSharedPreferences("myPreferences", MODE_PRIVATE);
        SharedPreferences.Editor shpEditor = shp.edit();
        shpEditor.putString(key, value);
        shpEditor.commit();
    }
}