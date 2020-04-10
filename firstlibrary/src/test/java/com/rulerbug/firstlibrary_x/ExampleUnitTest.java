package com.rulerbug.firstlibrary_x;

import com.rulerbug.firstlibrary_x.Domain.SmartTime;
import com.rulerbug.firstlibrary_x.Utils.BugSmartTimeUtils;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Calendar now = Calendar.getInstance();
        long start = now.getTimeInMillis();
        now.add(Calendar.YEAR, 22222121);
        long end = now.getTimeInMillis();
        SmartTime t = BugSmartTimeUtils.between(start, end);
        System.out.println(t.DES);
    }
}