public class EntityXPOrb extends Entity {
   public int a;
   public int b = 0;
   public int c;
   private int d = 5;
   private int e;

   public EntityXPOrb(World par1World, double par2, double par4, double par6, int par8) {
      super(par1World);
      this.a(0.5F, 0.5F);
      this.H = this.J / 2.0F;
      this.d(par2, par4, par6);
      this.u = (float)(Math.random() * 360.0);
      this.r = (float)(Math.random() * 0.2F - 0.1F) * 2.0F;
      this.s = (float)(Math.random() * 0.2) * 2.0F;
      this.t = (float)(Math.random() * 0.2F - 0.1F) * 2.0F;
      this.e = par8;
   }

   @Override
   protected boolean e_() {
      return false;
   }

   public EntityXPOrb(World par1World) {
      super(par1World);
      this.a(0.25F, 0.25F);
      this.H = this.J / 2.0F;
   }

   @Override
   protected void b() {
   }

   @Override
   public int b(float par1) {
      float f = 0.5F;
      if (f < 0.0F) {
         f = 0.0F;
      }

      if (f > 1.0F) {
         f = 1.0F;
      }

      int i = super.b(par1);
      int j = i & 0xFF;
      int k = i >> 16 & 0xFF;
      j += (int)(f * 15.0F * 16.0F);
      if (j > 240) {
         j = 240;
      }

      return j | k << 16;
   }

   @Override
   public void J_() {
      super.J_();
      if (this.c > 0) {
         this.c--;
      }

      this.l = this.o;
      this.m = this.p;
      this.n = this.q;
      this.s -= 0.03F;
      if (this.k.getBlockMaterial(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q)) == acn.h) {
         this.s = 0.2F;
         this.r = (this.U.nextFloat() - this.U.nextFloat()) * 0.2F;
         this.t = (this.U.nextFloat() - this.U.nextFloat()) * 0.2F;
         this.k.a(this, "random.fizz", 0.4F, 2.0F + this.U.nextFloat() * 0.4F);
      }

      this.h(this.o, (this.y.b + this.y.e) / 2.0, this.q);
      double d = 8.0;
      EntityPlayer entityplayer = this.k.a(this, d);
      if (entityplayer != null) {
         double d1 = (entityplayer.o - this.o) / d;
         double d2 = (entityplayer.p + entityplayer.I() - this.p) / d;
         double d3 = (entityplayer.q - this.q) / d;
         double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
         double d5 = 1.0 - d4;
         if (d5 > 0.0) {
            d5 *= d5;
            this.r += d1 / d4 * d5 * 0.1;
            this.s += d2 / d4 * d5 * 0.1;
            this.t += d3 / d4 * d5 * 0.1;
         }
      }

      this.b(this.r, this.s, this.t);
      float f = 0.98F;
      if (this.z) {
         f = 0.5880001F;
         int i = this.k.getBlockId(MathHelper.d(this.o), MathHelper.c(this.y.b) - 1, MathHelper.d(this.q));
         if (i > 0) {
            f = Block.m[i].ce * 0.98F;
         }
      }

      this.r *= f;
      this.s *= 0.98F;
      this.t *= f;
      if (this.z) {
         this.s *= -0.9F;
      }

      this.a++;
      this.b++;
      if (this.b >= 6000) {
         this.A();
      }
   }

   @Override
   public boolean g_() {
      return this.k.a(this.y, acn.g, this);
   }

   @Override
   protected void a(int par1) {
      this.a(md.b, par1);
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      this.K();
      this.d -= par2;
      if (this.d <= 0) {
         this.A();
      }

      return false;
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      par1NBTTagCompound.a("Health", (byte)this.d);
      par1NBTTagCompound.a("Age", (short)this.b);
      par1NBTTagCompound.a("Value", (short)this.e);
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      this.d = par1NBTTagCompound.e("Health") & 255;
      this.b = par1NBTTagCompound.e("Age");
      this.e = par1NBTTagCompound.e("Value");
   }

   @Override
   public void a(EntityPlayer par1EntityPlayer) {
      if (!this.k.F) {
         if (this.c == 0 && par1EntityPlayer.aD == 0) {
            par1EntityPlayer.aD = 2;
            this.k.a(this, "random.orb", 0.1F, 0.5F * ((this.U.nextFloat() - this.U.nextFloat()) * 0.7F + 1.8F));
            par1EntityPlayer.b(this, 1);
            par1EntityPlayer.i(this.e);
            this.A();
         }
      }
   }

   public int h() {
      return this.e;
   }

   public int i() {
      if (this.e >= 2477) {
         return 10;
      } else if (this.e >= 1237) {
         return 9;
      } else if (this.e >= 617) {
         return 8;
      } else if (this.e >= 307) {
         return 7;
      } else if (this.e >= 149) {
         return 6;
      } else if (this.e >= 73) {
         return 5;
      } else if (this.e >= 37) {
         return 4;
      } else if (this.e >= 17) {
         return 3;
      } else if (this.e >= 7) {
         return 2;
      } else {
         return this.e < 3 ? 0 : 1;
      }
   }

   public static int b(int par0) {
      if (par0 >= 2477) {
         return 2477;
      } else if (par0 >= 1237) {
         return 1237;
      } else if (par0 >= 617) {
         return 617;
      } else if (par0 >= 307) {
         return 307;
      } else if (par0 >= 149) {
         return 149;
      } else if (par0 >= 73) {
         return 73;
      } else if (par0 >= 37) {
         return 37;
      } else if (par0 >= 17) {
         return 17;
      } else if (par0 >= 7) {
         return 7;
      } else {
         return par0 < 3 ? 1 : 3;
      }
   }

   @Override
   public boolean k_() {
      return false;
   }
}
