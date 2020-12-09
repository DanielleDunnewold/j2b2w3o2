

public class Gene implements Comparable <Gene>{

    private int gene_id;
    private String symbol;
    private String Chromosome_map_location;
    private int Chromosome;
    static private int amount;

    public Gene(int gene_id, String symbol, String chromosome_map_location, String Chromosoom) {
        this.gene_id = gene_id;
        this.symbol = symbol;
        this.Chromosome_map_location = chromosome_map_location;;
        setChromosome(Chromosoom);
        amount++;
    }

    /**
     * gets the gene id
     * @return gene_id int id of the Gene
     */
    public int getGene_id() {
        return gene_id;
    }

    /**
     * sets the gene id
     * @param gene_id int, id of the gene
     */
    public void setGene_id(int gene_id) {
        this.gene_id = gene_id;
    }

    /**
     * gets the symbol of the gene
     * @return symbol, String symbol of the gene
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * sets the symbol of the gene
     * @param symbol, string symbol of the gene
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * gets the chromosome map location
     * @return Cromosome_map_location, string the chromosome map location of the gene
     */
    public String getChromosome_map_location() {
        return Chromosome_map_location;
    }

    /**
     * set the chromosome map location
     * @param chromosome_map_location, string the chromomsoem map location of the gene
     */
    public void setChromosome_map_location(String chromosome_map_location) {
        Chromosome_map_location = chromosome_map_location;}

    /**
     * get the chromosome number of the gene
      * @return Chromosome, int number of the chromosome the gene lays on
     */
    public int getChromosome() {
        return Chromosome;
    }

    /**
     * sets the chromsome number of the gene
     * @param chromosome, int number of the chromsome the gene is located on
     */
    public void setChromosome(String chromosome) {
        // checks if the chromosoom is X or Y and give the chromsome the right number(so it can be ordered easy later on
        if (chromosome.equals("X")){
            this.Chromosome=23; }
        else if (chromosome.equals("Y")){
            this.Chromosome=24; }

        //if the chromosome is - or un there is no known and it would be set to 0
        else if (chromosome.equals("-")||chromosome.equals("Un")){
            this.Chromosome=0;
        }

        // if the chromsome number contains a | the first number gets stored
        else if (chromosome.contains("|")){
            //if this is a x or y the number 23 or 24 is given to the value
            if(chromosome.split("\\|")[0].equals("X")){
                this.Chromosome=23;
            }
            else if(chromosome.split("\\|")[0].equals("Y")){
                this.Chromosome=24;
            }
            else{
            this.Chromosome= Integer.parseInt(chromosome.split("\\|")[0]);}
        }
        //if it is on the mitochondrial the number 25 is given so it gets easier ordered
        else if (chromosome.equals("MT")){
            this.Chromosome=25;
        }
        // if it is just a integer it gets conferted to a integer and that gets stored
        else{
        this.Chromosome = Integer.parseInt(chromosome); }
    }


    /**
     * overwrites the tostring method and prints the value of the chromosome map location
     * @return the chromsome map location
     */
    public String toString(){
        return String.valueOf(getChromosome_map_location());
    }

    /**
     * this function uses the compare to interface and compares the diffrent chromosomes so it can be filtered
     * @param g an other gene this gene gets compared to
     * @return a +1 when this chromosoom is higher,
     * a 0 when they are equal and
     * a -1 when this gene is lower than the other
     */
    public int compareTo(Gene g) {
        //when this chromosoom number is higher than the other +1 is returned
        if(this.getChromosome()>g.getChromosome()){
            return +1;
        }
        //when this chromosoom and the other are the same 0 is returned
        else if(this.getChromosome()==g.getChromosome()){
            return 0;
        }
        //otherwise this chromosoom has to be lower tha  the other so -1 is returned
        else{
            return-1;
        }}

//// this is an attempt on getting the location to filter aswell
//        String[] zelf_chromosoom;
//        String[] ander_chromosoom;
//        String zelf_chromosoom_part2=null;
//        String ander_chromosoom_part2=null;
//        System.out.println("ik kom hier langs "+this.getChromosome_map_location()+"\t"+g.getChromosome_map_location());
//
//
//        if(this.getChromosome_map_location().contains("|")){
//            zelf_chromosoom=this.getChromosome_map_location().split("\\|")[0].split("p|q");
//            System.out.println("test1 ");
//        }
//
//        else if(this.getChromosome_map_location().contains("-")){
//            zelf_chromosoom =this.getChromosome_map_location().split("-")[0].split("p|q");
//            System.out.println("test2");
//        }
//        else {
//            zelf_chromosoom =this.getChromosome_map_location().split("p|q");
//            System.out.println("test3");
//        }
//
//        if(g.getChromosome_map_location().contains("|")){
//            ander_chromosoom =g.getChromosome_map_location().split("\\|")[0].split("p|q");
//            System.out.println("test4");
//        }
//        else if(g.getChromosome_map_location().contains("-")){
//            ander_chromosoom =g.getChromosome_map_location().split("-")[0].split("p|q");
//            System.out.println("test5");
//        }
//        else {
//            ander_chromosoom =g.getChromosome_map_location().split("p|q");
//            System.out.println("test6");
//        }
//
//        if (this.getChromosome_map_location().equals(g.getChromosome_map_location())){
//            System.out.println("test7");
//            return 0;
//            }
//
//        else if (this.getChromosome()> g.getChromosome()){
//            if(zelf_chromosoom.length==0||ander_chromosoom.length==0){
//                System.out.println("testoo");
//                return +1;
//            }
//            System.out.println("test8");
//            if(zelf_chromosoom[1].contains(".")){
//            zelf_chromosoom_part2=zelf_chromosoom[1].split("\\.")[0];}
//            if(zelf_chromosoom[1].contains("-")){
//
//                zelf_chromosoom_part2=zelf_chromosoom[1].replace("-","");
//                System.out.println(zelf_chromosoom_part2);
//            }
//            if(!zelf_chromosoom[1].contains(".")&&!zelf_chromosoom[1].contains("-")){
//            zelf_chromosoom_part2=zelf_chromosoom[1];}
//
//
//            if(ander_chromosoom[1].contains(".")){
//                ander_chromosoom_part2=ander_chromosoom[1].split("\\.")[0];}
//            if(ander_chromosoom[1].contains("-")){
//                ander_chromosoom_part2=ander_chromosoom[1].replace("-","");
//                System.out.println("ik kom hier langs "+this.getChromosome_map_location()+"\t"+g.getChromosome_map_location());
//
//            }
//            if(!ander_chromosoom[1].contains(".")&&!ander_chromosoom[1].contains("-")){
//                ander_chromosoom_part2=ander_chromosoom[1];
//            }
//
//
//           if(Integer.parseInt(zelf_chromosoom_part2)>Integer.parseInt(ander_chromosoom_part2)){
//                return +1;
//            }
//            else{
//                return -1;
//             }}
//
//
//        else {System.out.println("test 9");
//            return -1;
//            }
//    }







}

