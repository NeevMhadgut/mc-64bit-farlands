public class EntityBlaze extends EntityMob {
   private float a = 0.5F;
   private int b;
   private int d;

   public EntityBlaze(World par1World) {
      super(par1World);
      this.bm = "/mob/fire.png";
      this.ab = true;
      this.c = 6;
      this.bI = 10;
   }

   @Override
   public int d() {
      return 20;
   }

   @Override
   protected void b() {
      super.b();
      this.EntityNoteFX.a(16, new Byte((byte)0));
   }

   @Override
   protected String m() {
      return "mob.blaze.breathe";
   }

   @Override
   protected String n() {
      return "mob.blaze.hit";
   }

   @Override
   protected String o() {
      return "mob.blaze.death";
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      return super.a(par1DamageSource, par2);
   }

   @Override
   public void a(md par1DamageSource) {
      super.a(par1DamageSource);
   }

   @Override
   public int b(float par1) {
      return 15728880;
   }

   @Override
   public float a(float par1) {
      return 1.0F;
   }

   @Override
   public void e() {
      if (!this.k.F) {
         if (this.G()) {
            this.a(md.f, 1);
         }

         this.b--;
         if (this.b <= 0) {
            this.b = 100;
            this.a = 0.5F + (float)this.U.nextGaussian() * 3.0F;
         }

         if (this.as() != null && this.as().p + this.as().I() > this.p + this.I() + this.a) {
            this.s = this.s + (0.3F - this.s) * 0.3F;
         }
      }

      if (this.U.nextInt(24) == 0) {
         this.k.a(this.o + 0.5, this.p + 0.5, this.q + 0.5, "fire.fire", 1.0F + this.U.nextFloat(), this.U.nextFloat() * 0.7F + 0.3F);
      }

      if (!this.z && this.s < 0.0) {
         this.s *= 0.6;
      }

      for (int i = 0; i < 2; i++) {
         this.k
            .a(
               "largesmoke",
               this.o + (this.U.nextDouble() - 0.5) * this.I,
               this.p + this.U.nextDouble() * this.J,
               this.q + (this.U.nextDouble() - 0.5) * this.I,
               0.0,
               0.0,
               0.0
            );
      }

      super.e();
   }

   @Override
   protected void a(Entity par1Entity, float par2) {
      if (this.bE <= 0 && par2 < 2.0F && par1Entity.y.e > this.y.b && par1Entity.y.b < this.y.e) {
         this.bE = 20;
         this.c(par1Entity);
      } else if (par2 < 30.0F) {
         double d = par1Entity.o - this.o;
         double d1 = par1Entity.y.b + par1Entity.J / 2.0F - (this.p + this.J / 2.0F);
         double d2 = par1Entity.q - this.q;
         if (this.bE == 0) {
            this.d++;
            if (this.d == 1) {
               this.bE = 60;
               this.a(true);
            } else if (this.d <= 4) {
               this.bE = 6;
            } else {
               this.bE = 100;
               this.d = 0;
               this.a(false);
            }

            if (this.d > 1) {
               float f = MathHelper.c(par2) * 0.5F;
               this.k.playAuxSFXAtEntity(null, 1009, (long)this.o, (int)this.p, (long)this.q, 0);

               for (int i = 0; i < 1; i++) {
                  EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.k, this, d + this.U.nextGaussian() * f, d1, d2 + this.U.nextGaussian() * f);
                  entitysmallfireball.p = this.p + this.J / 2.0F + 0.5;
                  this.k.a(entitysmallfireball);
               }
            }
         }

         this.u = (float)(Math.atan2(d2, d) * 180.0 / Math.PI) - 90.0F;
         this.ap = true;
      }
   }

   @Override
   protected void e(float f) {
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
   }

   @Override
   protected int f() {
      return Item.bo.bQ;
   }

   @Override
   public boolean T() {
      return this.TileEntityMobSpawnerRenderer();
   }

   @Override
   protected void a(boolean par1, int par2) {
      if (par1) {
         int i = this.U.nextInt(2 + par2);

         for (int j = 0; j < i; j++) {
            this.b(Item.bo.bQ, 1);
         }
      }
   }

   public boolean TileEntityMobSpawnerRenderer() {
      return (this.EntityNoteFX.a(16) & 1) != 0;
   }

   public void a(boolean par1) {
      byte byte0 = this.EntityNoteFX.a(16);
      if (par1) {
         byte0 = (byte)(byte0 | 1);
      } else {
         byte0 = (byte)(byte0 & 254);
      }

      this.EntityNoteFX.b(16, byte0);
   }

   @Override
   protected boolean BlockSnowBlock() {
      return true;
   }
}
