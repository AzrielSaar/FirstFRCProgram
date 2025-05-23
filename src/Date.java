public class Date {
    private int m_day;
    private int m_month;
    private int m_year;
    
    Date(int day, int month, int year){
        if(isValidDate(day, month, year) == false){
            m_day = 1;
            m_month = 1;
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
       } else if(month % 2 == 0 && m_month != 4){
           if(m_day > 30){
               return false;
           } 
       } else if(m_month == 4){
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

    //public void addDays(int num){}
    
}
