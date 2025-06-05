public class Date {
    private int m_day;
    private int m_month;
    private int m_year;

    private final int JAN = 1;
    private final int FEB = 2;
    private final int MAR = 3;
    private final int APRIL = 4;
    private final int MAY = 5;
    private final int JUNE = 6;
    private final int JULY = 7;
    private final int AUG = 8;
    private final int SEP = 9;
    private final int OCT = 10;
    private final int NOV = 11;
    private final int DEC = 12;





    Date(int day, int month, int year){
        if(!isValidDate(day, month, year)){
            m_day = 1;
            m_month = JAN;
            m_year = 2000;
        }else{
            m_day = day;
            m_month = month;
            m_year = year;
        }
    }

    boolean isValidDate(int day, int month, int year){
        if(month % 2 == 1){
            if(day > 31){
                return false;
            }
        } else if(month % 2 == 0 && m_month != FEB){
            if(m_day > 30){
                return false;
            }
        } else if(m_month == FEB){
            if((year % 4 == 0 && year % 100 != 0 ) || (year % 400 == 0)) {
                if(day > 29){
                    return false;
                }
            }else if(day > 28){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        return (m_day + "/" + m_month + "/" + m_year);
    }

    public boolean equals(Date date){
        if(date.m_day == m_day && date.m_month == m_month && date.m_year == m_year){
            return true;
        }
        return false;
    }

    public boolean before(Date date){
        if(m_year < date.m_year){
            return true;
        } else if (m_year == date.m_year && m_month < date.m_month) {
            return true;
        }else if(m_year == date.m_year && m_month == date.m_month && m_day < date.m_day){
            return true;
        }
        return false;
    }

    public void addDays(int days){
        if(((m_year%4 == 0 && m_year%100 != 0) || m_year%400 == 0) && m_month == FEB && m_day+days <= 29){
            m_day += days;
            days = 0;
        }else if(m_month == 4 && m_day+ days <= 28){
            m_day += days;
            days = 0;
        }else if(m_month%2 == 0 && m_day+days <= 30) {
            m_day += days;
            days = 0;
        }else if(m_month%2 == 1 && m_day + days <= 31) {
            m_day += days;
            days = 0;
        }else if(((m_year%4 == 0 && m_year%100 != 0) || m_year%400 == 0) && m_month == FEB){
            days -= 29 - m_day;
            m_day = 1;
            m_month += 1;
        }else if(m_month == FEB){
            days -= 28 - m_day;
            m_day = 1;
            m_month += 1;
        }else if(m_month == DEC){
            days -= 30 - m_day;
            m_day = 1;
            m_month = JAN;
            m_year += 1;
        }else if(m_month%2 == 0) {
            days -= 30 - m_day;
            m_day = 1;
            m_month += 1;
        }else if(m_month%2 == 1){
            days -= 31 - m_day;
            m_day = 1;
            m_month += 1;
        }

        while(days > 0){
            if(((m_year%4 == 0 && m_year%100 != 0) || m_year%400 == 0) && m_month == FEB && m_day+days <= 29){
                m_day += days;
                days = 0;
            }else if(m_month == 4 && m_day+ days <= 28){
                m_day += days;
                days = 0;
            }else if(m_month%2 == 0 && m_day+days <= 30) {
                m_day += days;
                days = 0;
            }else if(m_month%2 == 1 && m_day + days <= 31) {
                m_day += days;
                days = 0;
            }else if(((m_year%4 == 0 && m_year%100 != 0) || m_year%400 == 0) && m_month == FEB){
                days -= 29;
                m_day = 1;
                m_month += 1;
            }else if(m_month == FEB){
                days -= 28;
                m_day = 1;
                m_month += 1;
            }else if(m_month == DEC){
                days -= 30;
                m_day = 1;
                m_month = JAN;
                m_year += 1;
            }else if(m_month%2 == 0) {
                days -= 30;
                m_day = 1;
                m_month += 1;
            }else if(m_month%2 == 1){
                days -= 31;
                m_day = 1;
                m_month += 1;
            }
        }
    }

    public int getDay() {
        return m_day;
    }

    public int getMonth() {
        return m_month;
    }

    public int getYear() {
        return m_year;
    }


}