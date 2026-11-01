import java.util.Comparator;

public class EntitySorter implements Comparator {
   private double a;
   private double b;
   private double c;

   public EntitySorter(Entity par1Entity) {
      this.a = -par1Entity.o;
      this.b = -par1Entity.p;
      this.c = -par1Entity.q;
   }

   public int a(WorldRenderer par1WorldRenderer, WorldRenderer par2WorldRenderer) {
      double d = par1WorldRenderer.n + this.a;
      double d1 = par1WorldRenderer.o + this.b;
      double d2 = par1WorldRenderer.p + this.c;
      double d3 = par2WorldRenderer.n + this.a;
      double d4 = par2WorldRenderer.o + this.b;
      double d5 = par2WorldRenderer.p + this.c;
      return (int)((d * d + d1 * d1 + d2 * d2 - (d3 * d3 + d4 * d4 + d5 * d5)) * 1024.0);
   }

   @Override
   public int compare(Object par1Obj, Object par2Obj) {
      return this.a((WorldRenderer)par1Obj, (WorldRenderer)par2Obj);
   }
}
