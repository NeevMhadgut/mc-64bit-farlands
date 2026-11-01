import java.util.Random;

public class NoiseGeneratorOctaves extends cp {
   private NoiseGeneratorPerlin[] a;
   private int b;

   public NoiseGeneratorOctaves(Random par1Random, int par2) {
      this.b = par2;
      this.a = new NoiseGeneratorPerlin[par2];

      for (int i = 0; i < par2; i++) {
         this.a[i] = new NoiseGeneratorPerlin(par1Random);
      }
   }

   public double[] generateNoiseOctaves(
      double[] par1ArrayOfDouble, long par2, long par3, long par4, int par5, int par6, int par7, double par8, double par10, double par12
   ) {
      if (par1ArrayOfDouble == null) {
         par1ArrayOfDouble = new double[par5 * par6 * par7];
      } else {
         for (int i = 0; i < par1ArrayOfDouble.length; i++) {
            par1ArrayOfDouble[i] = 0.0;
         }
      }

      double d = 1.0;

      for (int j = 0; j < this.b; j++) {
         double d1 = par2 * d * par8;
         double d2 = par3 * d * par10;
         double d3 = par4 * d * par12;
         long l = MathHelper.d(d1);
         long l1 = MathHelper.d(d3);
         this.a[j].a(par1ArrayOfDouble, d1, d2, d3, par5, par6, par7, par8 * d, par10 * d, par12 * d, d);
         d /= 2.0;
      }

      return par1ArrayOfDouble;
   }

   public double[] generateNoiseOctaves(double[] par1ArrayOfDouble, long par2, long par3, int par4, int par5, double par6, double par8, double par10) {
      return this.generateNoiseOctaves(par1ArrayOfDouble, par2, 10L, par3, par4, 1, par5, par6, 1.0, par8);
   }
}
