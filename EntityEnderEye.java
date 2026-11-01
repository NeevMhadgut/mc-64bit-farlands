public class EntityEnderEye extends Entity {
   public int a = 0;
   private double b;
   private double c;
   private double d;
   private int e;
   private boolean NoiseGeneratorPerlin;

   public EntityEnderEye(World par1World) {
      super(par1World);
      this.a(0.25F, 0.25F);
   }

   @Override
   protected void b() {
   }

   @Override
   public boolean a(double par1) {
      double d = this.y.c() * 4.0;
      d *= 64.0;
      return par1 < d * d;
   }

   public EntityEnderEye(World par1World, double par2, double par4, double par6) {
      super(par1World);
      this.e = 0;
      this.a(0.25F, 0.25F);
      this.d(par2, par4, par6);
      this.H = 0.0F;
   }

   public void a(double par1, int par3, double par4) {
      double d = par1 - this.o;
      double d1 = par4 - this.q;
      float f = MathHelper.a(d * d + d1 * d1);
      if (f > 12.0F) {
         this.b = this.o + d / f * 12.0;
         this.d = this.q + d1 / f * 12.0;
         this.c = this.p + 8.0;
      } else {
         this.b = par1;
         this.c = par3;
         this.d = par4;
      }

      this.e = 0;
      this.NoiseGeneratorPerlin = this.U.nextInt(5) > 0;
   }

   @Override
   public void a(double par1, double par3, double par5) {
      this.r = par1;
      this.s = par3;
      this.t = par5;
      if (this.x == 0.0F && this.w == 0.0F) {
         float f = MathHelper.a(par1 * par1 + par5 * par5);
         this.w = this.u = (float)(Math.atan2(par1, par5) * 180.0 / Math.PI);
         this.x = this.v = (float)(Math.atan2(par3, f) * 180.0 / Math.PI);
      }
   }

   @Override
   public void J_() {
      this.N = this.o;
      this.O = this.p;
      this.P = this.q;
      super.J_();
      this.o = this.o + this.r;
      this.p = this.p + this.s;
      this.q = this.q + this.t;
      float f = MathHelper.a(this.r * this.r + this.t * this.t);
      this.u = (float)(Math.atan2(this.r, this.t) * 180.0 / Math.PI);
      this.v = (float)(Math.atan2(this.s, f) * 180.0 / Math.PI);

      while (this.v - this.x < -180.0F) {
         this.x -= 360.0F;
      }

      while (this.v - this.x >= 180.0F) {
         this.x += 360.0F;
      }

      while (this.u - this.w < -180.0F) {
         this.w -= 360.0F;
      }

      while (this.u - this.w >= 180.0F) {
         this.w += 360.0F;
      }

      this.v = this.x + (this.v - this.x) * 0.2F;
      this.u = this.w + (this.u - this.w) * 0.2F;
      if (!this.k.F) {
         double d = this.b - this.o;
         double d1 = this.d - this.q;
         float f2 = (float)Math.sqrt(d * d + d1 * d1);
         float f3 = (float)Math.atan2(d1, d);
         double d2 = f + (f2 - f) * 0.0025;
         if (f2 < 1.0F) {
            d2 *= 0.8;
            this.s *= 0.8;
         }

         this.r = Math.cos(f3) * d2;
         this.t = Math.sin(f3) * d2;
         if (this.p < this.c) {
            this.s = this.s + (1.0 - this.s) * 0.015F;
         } else {
            this.s = this.s + (-1.0 - this.s) * 0.015F;
         }
      }

      float f1 = 0.25F;
      if (this.H()) {
         for (int i = 0; i < 4; i++) {
            this.k.a("bubble", this.o - this.r * f1, this.p - this.s * f1, this.q - this.t * f1, this.r, this.s, this.t);
         }
      } else {
         this.k
            .a(
               "portal",
               this.o - this.r * f1 + this.U.nextDouble() * 0.6 - 0.3,
               this.p - this.s * f1 - 0.5,
               this.q - this.t * f1 + this.U.nextDouble() * 0.6 - 0.3,
               this.r,
               this.s,
               this.t
            );
      }

      if (!this.k.F) {
         this.d(this.o, this.p, this.q);
         this.e++;
         if (this.e > 80 && !this.k.F) {
            this.A();
            if (this.NoiseGeneratorPerlin) {
               this.k.a(new EntityItem(this.k, this.o, this.p, this.q, new ItemStack(Item.bA)));
            } else {
               String s = "iconcrack_" + Item.bA.bQ;

               for (int i1 = 0; i1 < 8; i1++) {
                  this.k.a(s, this.o, this.p, this.q, this.U.nextGaussian() * 0.15, this.U.nextDouble() * 0.2, this.U.nextGaussian() * 0.15);
               }

               for (double d12 = 0.0; d12 < Math.PI * 2; d12 += Math.PI / 20) {
                  this.k.a("portal", this.o + Math.cos(d12) * 5.0, this.p - 0.4, this.q + Math.sin(d12) * 5.0, Math.cos(d12) * -5.0, 0.0, Math.sin(d12) * -5.0);
                  this.k.a("portal", this.o + Math.cos(d12) * 5.0, this.p - 0.4, this.q + Math.sin(d12) * 5.0, Math.cos(d12) * -7.0, 0.0, Math.sin(d12) * -7.0);
               }
            }
         }
      }
   }

   @Override
   public void b(ady nbttagcompound) {
   }

   @Override
   public void a(ady nbttagcompound) {
   }

   @Override
   public void a(EntityPlayer entityplayer) {
   }

   @Override
   public float h_() {
      return 0.0F;
   }

   @Override
   public float a(float par1) {
      return 1.0F;
   }

   @Override
   public int b(float par1) {
      return 15728880;
   }

   @Override
   public boolean k_() {
      return false;
   }
}
