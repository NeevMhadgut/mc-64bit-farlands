import java.util.List;

public abstract class EntityAnimal extends ajr {
   private int a;
   private int b = 0;

   public EntityAnimal(World par1World) {
      super(par1World);
   }

   protected void g() {
      if (this.EntityThrowable() != 0) {
         this.a = 0;
      }

      super.g();
   }

   public void e() {
      super.e();
      if (this.EntityThrowable() != 0) {
         this.a = 0;
      }

      if (this.a > 0) {
         this.a--;
         String s = "heart";
         if (this.a % 10 == 0) {
            double d = this.U.nextGaussian() * 0.02;
            double d1 = this.U.nextGaussian() * 0.02;
            double d2 = this.U.nextGaussian() * 0.02;
            this.k
               .a(
                  s,
                  this.o + this.U.nextFloat() * this.I * 2.0F - this.I,
                  this.p + 0.5 + this.U.nextFloat() * this.J,
                  this.q + this.U.nextFloat() * this.I * 2.0F - this.I,
                  d,
                  d1,
                  d2
               );
         }
      } else {
         this.b = 0;
      }
   }

   protected void a(Entity par1Entity, float par2) {
      if (par1Entity instanceof EntityPlayer) {
         if (par2 < 3.0F) {
            double d = par1Entity.o - this.o;
            double d1 = par1Entity.q - this.q;
            this.u = (float)(Math.atan2(d1, d) * 180.0 / Math.PI) - 90.0F;
            this.ap = true;
         }

         EntityPlayer entityplayer = (EntityPlayer)par1Entity;
         if (entityplayer.EntityThrowable() == null || !this.a(entityplayer.EntityThrowable())) {
            this.GenLayerHills = null;
         }
      } else if (par1Entity instanceof EntityAnimal) {
         EntityAnimal entityanimal = (EntityAnimal)par1Entity;
         if (this.EntityThrowable() > 0 && entityanimal.EntityThrowable() < 0) {
            if (par2 < 2.5) {
               this.ap = true;
            }
         } else if (this.a > 0 && entityanimal.a > 0) {
            if (entityanimal.GenLayerHills == null) {
               entityanimal.GenLayerHills = this;
            }

            if (entityanimal.GenLayerHills == this && par2 < 3.5) {
               entityanimal.a++;
               this.a++;
               this.b++;
               if (this.b % 4 == 0) {
                  this.k
                     .a(
                        "heart",
                        this.o + this.U.nextFloat() * this.I * 2.0F - this.I,
                        this.p + 0.5 + this.U.nextFloat() * this.J,
                        this.q + this.U.nextFloat() * this.I * 2.0F - this.I,
                        0.0,
                        0.0,
                        0.0
                     );
               }

               if (this.b == 60) {
                  this.c((EntityAnimal)par1Entity);
               }
            } else {
               this.b = 0;
            }
         } else {
            this.b = 0;
            this.GenLayerHills = null;
         }
      }
   }

   private void c(EntityAnimal par1EntityAnimal) {
      EntityAnimal entityanimal = this.a(par1EntityAnimal);
      if (entityanimal != null) {
         this.d(6000);
         par1EntityAnimal.d(6000);
         this.a = 0;
         this.b = 0;
         this.GenLayerHills = null;
         par1EntityAnimal.GenLayerHills = null;
         par1EntityAnimal.b = 0;
         par1EntityAnimal.a = 0;
         entityanimal.d(-24000);
         entityanimal.c(this.o, this.p, this.q, this.u, this.v);

         for (int i = 0; i < 7; i++) {
            double d = this.U.nextGaussian() * 0.02;
            double d1 = this.U.nextGaussian() * 0.02;
            double d2 = this.U.nextGaussian() * 0.02;
            this.k
               .a(
                  "heart",
                  this.o + this.U.nextFloat() * this.I * 2.0F - this.I,
                  this.p + 0.5 + this.U.nextFloat() * this.J,
                  this.q + this.U.nextFloat() * this.I * 2.0F - this.I,
                  d,
                  d1,
                  d2
               );
         }

         this.k.a(entityanimal);
      }
   }

   public abstract EntityAnimal a(EntityAnimal var1);

   protected void b(Entity entity, float f) {
   }

   public boolean a(md par1DamageSource, int par2) {
      this.aq = 60;
      this.GenLayerHills = null;
      this.a = 0;
      return super.a(par1DamageSource, par2);
   }

   public float getBlockPathWeight(long par1, int par2, long par3) {
      return this.k.getBlockId(par1, par2 - 1, par3) == Block.u.bO ? 10.0F : this.k.getLightBrightness(par1, par2, par3) - 0.5F;
   }

   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      par1NBTTagCompound.a("InLove", this.a);
   }

   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      this.a = par1NBTTagCompound.f("InLove");
   }

   protected Entity h() {
      if (this.aq > 0) {
         return null;
      }

      float f = 8.0F;
      if (this.a > 0) {
         List list = this.k.a(this.getClass(), this.y.b(f, f, f));

         for (int i = 0; i < list.size(); i++) {
            EntityAnimal entityanimal = (EntityAnimal)list.get(i);
            if (entityanimal != this && entityanimal.a > 0) {
               return entityanimal;
            }
         }
      } else if (this.EntityThrowable() == 0) {
         List list1 = this.k.a(EntityPlayer.class, this.y.b(f, f, f));

         for (int j = 0; j < list1.size(); j++) {
            EntityPlayer entityplayer = (EntityPlayer)list1.get(j);
            if (entityplayer.EntityThrowable() != null && this.a(entityplayer.EntityThrowable())) {
               return entityplayer;
            }
         }
      } else if (this.EntityThrowable() > 0) {
         List list2 = this.k.a(this.getClass(), this.y.b(f, f, f));

         for (int k = 0; k < list2.size(); k++) {
            EntityAnimal entityanimal1 = (EntityAnimal)list2.get(k);
            if (entityanimal1 != this && entityanimal1.EntityThrowable() < 0) {
               return entityanimal1;
            }
         }
      }

      return null;
   }

   public boolean i() {
      long i = MathHelper.d(this.o);
      int j = MathHelper.c(this.y.b);
      long k = MathHelper.d(this.q);
      return this.k.getBlockId(i, j - 1, k) == Block.u.bO && this.k.getFullBlockLightValue(i, j, k) > 8 && super.i();
   }

   public int j() {
      return 120;
   }

   protected boolean c_() {
      return false;
   }

   protected int b(EntityPlayer par1EntityPlayer) {
      return 1 + this.k.r.nextInt(3);
   }

   public boolean a(ItemStack par1ItemStack) {
      return par1ItemStack.c == Item.T.bQ;
   }

   public boolean c(EntityPlayer par1EntityPlayer) {
      ItemStack itemstack = par1EntityPlayer.ap.b();
      if (itemstack != null && this.a(itemstack) && this.EntityThrowable() == 0) {
         if (!par1EntityPlayer.aT.d) {
            itemstack.a--;
            if (itemstack.a <= 0) {
               par1EntityPlayer.ap.a(par1EntityPlayer.ap.c, null);
            }
         }

         this.a = 600;
         this.GenLayerHills = null;

         for (int i = 0; i < 7; i++) {
            double d = this.U.nextGaussian() * 0.02;
            double d1 = this.U.nextGaussian() * 0.02;
            double d2 = this.U.nextGaussian() * 0.02;
            this.k
               .a(
                  "heart",
                  this.o + this.U.nextFloat() * this.I * 2.0F - this.I,
                  this.p + 0.5 + this.U.nextFloat() * this.J,
                  this.q + this.U.nextFloat() * this.I * 2.0F - this.I,
                  d,
                  d1,
                  d2
               );
         }

         return true;
      } else {
         return super.c(par1EntityPlayer);
      }
   }

   public boolean o_() {
      return this.a > 0;
   }

   public void p_() {
      this.a = 0;
   }

   public boolean b(EntityAnimal par1EntityAnimal) {
      if (par1EntityAnimal == this) {
         return false;
      } else {
         return par1EntityAnimal.getClass() != this.getClass() ? false : this.o_() && par1EntityAnimal.o_();
      }
   }
}
