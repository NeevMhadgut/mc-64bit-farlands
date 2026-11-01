import java.util.ArrayList;
import java.util.List;

public class MapGenNetherBridge extends MapGenStructure {
   private List a = new ArrayList();

   public MapGenNetherBridge() {
      this.a.add(new bg(EntityBlaze.class, 10, 2, 3));
      this.a.add(new bg(alt.class, 10, 4, 4));
      this.a.add(new bg(aic.class, 3, 4, 4));
   }

   public List b() {
      return this.a;
   }

   @Override
   protected boolean canSpawnStructureAtCoords(long par1, long par2) {
      long i = par1 >> 4;
      long j = par2 >> 4;
      this.c.setSeed(i ^ j << 4 ^ this.d.v());
      this.c.nextInt();
      if (this.c.nextInt(3) != 0) {
         return false;
      } else {
         return par1 != (i << 4) + 4L + this.c.nextInt(8) ? false : par2 == (j << 4) + 4L + this.c.nextInt(8);
      }
   }

   @Override
   protected StructureStart getStructureStart(long par1, long par2) {
      return new StructureNetherBridgeStart(this.d, this.c, par1, par2);
   }
}
