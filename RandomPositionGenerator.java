import java.util.Random;

public class RandomPositionGenerator {
   private static bo a = bo.a(0.0, 0.0, 0.0);

   public static bo a(EntityCreature par0EntityCreature, int par1, int par2) {
      return c(par0EntityCreature, par1, par2, null);
   }

   public static bo a(EntityCreature par0EntityCreature, int par1, int par2, bo par3Vec3D) {
      a.a = par3Vec3D.a - par0EntityCreature.o;
      a.b = par3Vec3D.b - par0EntityCreature.p;
      a.c = par3Vec3D.c - par0EntityCreature.q;
      return c(par0EntityCreature, par1, par2, a);
   }

   public static bo b(EntityCreature par0EntityCreature, int par1, int par2, bo par3Vec3D) {
      a.a = par0EntityCreature.o - par3Vec3D.a;
      a.b = par0EntityCreature.p - par3Vec3D.b;
      a.c = par0EntityCreature.q - par3Vec3D.c;
      return c(par0EntityCreature, par1, par2, a);
   }

   private static bo c(EntityCreature par0EntityCreature, int par1, int par2, bo par3Vec3D) {
      Random random = par0EntityCreature.aO();
      boolean flag = false;
      long i = 0L;
      int j = 0;
      long k = 0L;
      float f = -99999.0F;
      boolean flag1;
      if (par0EntityCreature.aY()) {
         double d = par0EntityCreature.aV().getEuclideanDistanceTo(MathHelper.d(par0EntityCreature.o), MathHelper.c(par0EntityCreature.p), MathHelper.d(par0EntityCreature.q)) + 4.0;
         flag1 = d < par0EntityCreature.aW() + par1;
      } else {
         flag1 = false;
      }

      for (int l = 0; l < 10; l++) {
         long i1 = random.nextInt(2 * par1) - par1;
         int j1 = random.nextInt(2 * par2) - par2;
         long k1 = random.nextInt(2 * par1) - par1;
         if (par3Vec3D == null || !(i1 * par3Vec3D.a + k1 * par3Vec3D.c < 0.0)) {
            i1 += MathHelper.d(par0EntityCreature.o);
            j1 += MathHelper.c(par0EntityCreature.p);
            k1 += MathHelper.d(par0EntityCreature.q);
            if (!flag1 || par0EntityCreature.isWithinHomeDistance(i1, j1, k1)) {
               float f1 = par0EntityCreature.getBlockPathWeight(i1, j1, k1);
               if (f1 > f) {
                  f = f1;
                  i = i1;
                  j = j1;
                  k = k1;
                  flag = true;
               }
            }
         }
      }

      return flag ? bo.b(i, j, k) : null;
   }
}
