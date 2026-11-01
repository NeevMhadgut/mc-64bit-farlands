import java.util.Random;

public class BiomeGenSwamp extends BiomeGenBase {
   protected BiomeGenSwamp(int par1) {
      super(par1);
      this.I.z = 2;
      this.I.A = -999;
      this.I.C = 1;
      this.I.D = 8;
      this.I.E = 10;
      this.I.I = 1;
      this.I.y = 4;
   }

   @Override
   public WorldGenerator a(Random par1Random) {
      return this.Q;
   }

   @Override
   public int k() {
      double d = this.j();
      double d1 = this.i();
      return zv.a(d, d1);
   }

   @Override
   public int l() {
      double d = this.j();
      double d1 = this.i();
      return ColorizerFoliage.a(d, d1);
   }
}
