public class Baby {
    private String m_name;
    private final String m_id;
    private final Date m_birthDate;
    private final Weight m_birthWeight;
    private  Weight m_currentWeight;

    Baby(String name, String id, Date birthDate, Weight birthWeight){
        m_name = name;
        if(id.length() != 9){
            m_id = "000000000";
        } else{
            m_id = id;
        }
        m_birthDate = birthDate;
        m_birthWeight = birthWeight;
        m_currentWeight = birthWeight;
    }

    Baby(Baby baby){
        m_name = baby.m_name;
        m_id = baby.m_id;
        m_birthDate = baby.m_birthDate;
        m_birthWeight = baby.m_birthWeight;
        m_currentWeight = baby.m_birthWeight;
    }

    String[] parts = m_name.split(" ");
    public String getFirstName(){
        String firstName = parts[0];
        return firstName;
    }

    public String getLastName(){
        String lastName = parts[parts.length - 1];
        return lastName;
    }

    public String getId(){
        return m_id;
    }

    public Date getBirthDate() {
        return m_birthDate;
    }

    public Weight getBirthWeight() {
        return m_birthWeight;
    }

    public Weight getCurrentWeight() {
        return m_currentWeight;
    }

    public void setCurrentWeight(Weight currentWeight) {
        m_currentWeight = currentWeight;
    }

    @Override
    public String toString(){
        return ("Name: " + m_name
                + "\nId: " + m_id
                + "\nDate of Birth: " + m_birthDate.toString()
                + "\nBirth Weight: " + (m_birthWeight.getKg() + (m_birthWeight.getGrams()/1000))
                + "\nCurrent Weight: " + (m_currentWeight.getKg() + (m_currentWeight.getGrams()/1000)));
    }

    public boolean equals(Baby baby){
        if(m_name == baby.m_name && m_id == baby.m_id && m_birthDate.equals(baby.m_birthDate)) {
            return true;
        }else{
            return false;
        }
    }

    public boolean heavier (Baby baby){
        return (baby.m_currentWeight.getKg() + baby.m_currentWeight.getGrams()/1000) > (m_currentWeight.getKg() + m_currentWeight.getGrams()/1000) ? true:false;
    }

    public void updateCurrentWeight(int grams){
        int kg = m_currentWeight.getKg();
        int currentGrams = m_currentWeight.getGrams();

        kg -= grams/1000;
        if((currentGrams + (grams%1000)) < 0){
            kg -= 1;
            currentGrams = 1000-(grams + currentGrams);
        }

        m_currentWeight = new Weight(kg, currentGrams);
    }


}
