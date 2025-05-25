public class Weight {
    private  int m_kg;
    private int m_grams;

    public Weight(int kg, int grams) {
        m_kg = kg + grams/1000;
        m_grams = grams%1000;
    }

    @Override
    public String toString(){
        return (m_kg + "kg and " + m_grams + "grams");
    }

    public int getKg() {
        return m_kg;
    }

    public int getGrams() {
        return m_grams;
    }

    public boolean equals(Weight weight){
        return (m_kg == weight.m_kg) &&  (m_grams == weight.m_grams) ? true: false;
    }

    public boolean lessThan(Weight weight){
        if(m_kg < weight.m_kg){
            return true;
        } else if (m_kg == weight.m_kg && m_grams < weight.m_grams) {
            return true;
        }
        return false;
    }

    public Weight add(Weight weight){
        return new Weight((m_kg + weight.m_kg), (m_grams + weight.m_grams));
    }
}
