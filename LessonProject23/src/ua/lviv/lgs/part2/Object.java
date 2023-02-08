package ua.lviv.lgs.part2;


public class Object implements Comparable<Object>{

    private String name;
    private int quont;
    
    
    public Object(String name, int quont) {
        this.name = name;
        this.quont = quont;
    }
    public Object() {
        }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getQuont() {
        return quont;
    }


    public void setQuont(int quont) {
        this.quont = quont;
    }


    @Override
    public String toString() {
        return "name=" + name + ", quont=" + quont;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + quont;
        return result;
    }
    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Object other = (Object) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (quont != other.quont)
            return false;
        return true;
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(o.getName());
    }
}
