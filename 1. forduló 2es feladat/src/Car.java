public class Car {
    String rendszam;
    int utszakasz,time,time2,dis;
    float allTimeH,avSpeed;
    public Car(String rendszam, int FH,int FM,int SH,int SM,int utszakasz)
    {
        this.rendszam=rendszam;
        this.utszakasz=utszakasz;
        if(SH==0 && FH!=0)
            SH=24;
        this.time=FH*60+FM;
        this.time2=SH*60+SM;
        this.allTimeH=(float)(time2-time)/(float)60;
        this.avSpeed=10/allTimeH;
    }
}
