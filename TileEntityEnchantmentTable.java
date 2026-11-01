import java.util.Random;

public class TileEntityEnchantmentTable extends TileEntity {
   public int a;
   public float b;
   public float c;
   public float d;
   public float e;
   public float f;
   public float g;
   public float h;
   public float p;
   public float q;
   private static Random r = new Random();

   @Override
   public void n_() {
      super.n_();
      this.g = this.f;
      this.p = this.h;
      EntityPlayer entityplayer = this.i.a(this.j + 0.5, this.k + 0.5F, this.l + 0.5, 3.0);
      if (entityplayer != null) {
         double d = entityplayer.o - (this.j + 0.5);
         double d1 = entityplayer.q - (this.l + 0.5);
         this.q = (float)Math.atan2(d1, d);
         this.f += 0.1F;
         if (this.f < 0.5F || r.nextInt(40) == 0) {
            float f3 = this.d;

            do {
               this.d = this.d + (r.nextInt(4) - r.nextInt(4));
            } while (f3 == this.d);
         }
      } else {
         this.q += 0.02F;
         this.f -= 0.1F;
      }

      while (this.h >= (float) Math.PI) {
         this.h -= (float) (Math.PI * 2);
      }

      while (this.h < (float) -Math.PI) {
         this.h += (float) (Math.PI * 2);
      }

      while (this.q >= (float) Math.PI) {
         this.q -= (float) (Math.PI * 2);
      }

      while (this.q < (float) -Math.PI) {
         this.q += (float) (Math.PI * 2);
      }

      float f = this.q - this.h;

      while (f >= (float) Math.PI) {
         f -= (float) (Math.PI * 2);
      }

      while (f < (float) -Math.PI) {
         f += (float) (Math.PI * 2);
      }

      this.h += f * 0.4F;
      if (this.f < 0.0F) {
         this.f = 0.0F;
      }

      if (this.f > 1.0F) {
         this.f = 1.0F;
      }

      this.a++;
      this.c = this.b;
      float f1 = (this.d - this.b) * 0.4F;
      float f2 = 0.2F;
      if (f1 < -f2) {
         f1 = -f2;
      }

      if (f1 > f2) {
         f1 = f2;
      }

      this.e = this.e + (f1 - this.e) * 0.9F;
      this.b = this.b + this.e;
   }
}
