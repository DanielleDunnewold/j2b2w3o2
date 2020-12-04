import javax.swing.*;
import java.util.Arrays;

public class Gene implements Comparable <Gene>{

    private int gene_id;
    private String symbol;
    private String Chromosome_map_location;
    private int Chromosome;
    static private int amount;

    public Gene(int gene_id, String symbol, String chromosome_map_location, String Chromosoom) {
        this.gene_id = gene_id;
        this.symbol = symbol;
        setChromosome_map_location(chromosome_map_location);
        setChromosome(Chromosoom);
        amount++;
    }

    public int getGene_id() {
        return gene_id;
    }

    public void setGene_id(int gene_id) {
        this.gene_id = gene_id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getChromosome_map_location() {
        return Chromosome_map_location;
    }

    public void setChromosome_map_location(String chromosome_map_location) {
        if(chromosome_map_location.equals("-")){
            Chromosome_map_location = "0p0";
        }
        else{Chromosome_map_location = chromosome_map_location;} }

    public int getChromosome() {
        return Chromosome;
    }

    public void setChromosome(String chromosome) {
        if (chromosome.equals("X")){
            this.Chromosome=23; }
        else if (chromosome.equals("Y")){
            this.Chromosome=24; }
        else if (chromosome.equals("-")||chromosome.contains("|")||chromosome.equals("Un")){
            this.Chromosome=0;
        }
        else if (chromosome.equals("MT")){
            this.Chromosome=25;
        }
        else{
        this.Chromosome = Integer.parseInt(chromosome);}
    }

    public int compareTo(Gene g) {


//        if(this.getChromosome()>g.getChromosome()){
//            return +1;
//        }
//        else if(this.getChromosome()==g.getChromosome()){
//            return 0;
//        }
//        else{
//            return-1;
//        }

//
        String[] zelf_chromosoom;
        String[] ander_chromosoom;
        String zelf_chromosoom_part2=null;
        String ander_chromosoom_part2=null;
        System.out.println("ik kom hier langs "+this.getChromosome_map_location()+"\t"+g.getChromosome_map_location());


        if(this.getChromosome_map_location().contains("|")){
            zelf_chromosoom=this.getChromosome_map_location().split("\\|")[0].split("p|q");
            System.out.println("test1 ");
        }

        else if(this.getChromosome_map_location().contains("-")){
            zelf_chromosoom =this.getChromosome_map_location().split("-")[0].split("p|q");
            System.out.println("test2");
        }
        else {
            zelf_chromosoom =this.getChromosome_map_location().split("p|q");
            System.out.println("test3");
        }

        if(g.getChromosome_map_location().contains("|")){
            ander_chromosoom =g.getChromosome_map_location().split("\\|")[0].split("p|q");
            System.out.println("test4");
        }
        else if(g.getChromosome_map_location().contains("-")){
            ander_chromosoom =g.getChromosome_map_location().split("-")[0].split("p|q");
            System.out.println("test5");
        }
        else {
            ander_chromosoom =g.getChromosome_map_location().split("p|q");
            System.out.println("test6");
        }

        if (this.getChromosome_map_location().equals(g.getChromosome_map_location())){
            System.out.println("test7");
            return 0;
            }

        else if (this.getChromosome()> g.getChromosome()){
            if(zelf_chromosoom.length==0||ander_chromosoom.length==0){
                System.out.println("testoo");
                return +1;
            }
            System.out.println("test8");
            if(zelf_chromosoom[1].contains(".")){
            zelf_chromosoom_part2=zelf_chromosoom[1].split("\\.")[0];}
            if(zelf_chromosoom[1].contains("-")){

                zelf_chromosoom_part2=zelf_chromosoom[1].replace("-","");
                System.out.println(zelf_chromosoom_part2);
            }
            if(!zelf_chromosoom[1].contains(".")&&!zelf_chromosoom[1].contains("-")){
            zelf_chromosoom_part2=zelf_chromosoom[1];}


            if(ander_chromosoom[1].contains(".")){
                ander_chromosoom_part2=ander_chromosoom[1].split("\\.")[0];}
            if(ander_chromosoom[1].contains("-")){
                ander_chromosoom_part2=ander_chromosoom[1].replace("-","");
                System.out.println("ik kom hier langs "+this.getChromosome_map_location()+"\t"+g.getChromosome_map_location());

            }
            if(!ander_chromosoom[1].contains(".")&&!ander_chromosoom[1].contains("-")){
                ander_chromosoom_part2=ander_chromosoom[1];
            }


           if(Integer.parseInt(zelf_chromosoom_part2)>Integer.parseInt(ander_chromosoom_part2)){
                return +1;
            }
            else{
                return -1;
             }}


        else {System.out.println("test 9");
            return -1;
            }
    }







    public String toString(){
        return String.valueOf(getChromosome_map_location());
    }

}

