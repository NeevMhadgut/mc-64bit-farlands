import java.util.Comparator;

public class RenderSorter implements Comparator {
   private EntityLiving a;

   public RenderSorter(EntityLiving par1EntityLiving) {
      this.a = par1EntityLiving;
   }

   public int a(WorldRenderer par1WorldRenderer, WorldRenderer par2WorldRenderer) {
      if (par1WorldRenderer.l && !par2WorldRenderer.l) {
         return 1;
      } else if (par2WorldRenderer.l && !par1WorldRenderer.l) {
         return -1;
      } else {
         double d = par1WorldRenderer.distanceToEntitySquared(this.a);
         double d1 = par2WorldRenderer.distanceToEntitySquared(this.a);
         if (d < d1) {
            return 1;
         } else if (d > d1) {
            return -1;
         } else {
            return par1WorldRenderer.s >= par2WorldRenderer.s ? -1 : 1;
         }
      }
   }

   @Override
   public int compare(Object par1Obj, Object par2Obj) {
      return this.a((WorldRenderer)par1Obj, (WorldRenderer)par2Obj);
   }
}
