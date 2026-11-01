public class TileEntityMobSpawner extends TileEntity {
   public int a = -1;
   private String d;
   public double b;
   public double c = 0.0;

   public TileEntityMobSpawner() {
      this.d = "Pig";
      this.a = 20;
   }

   public String a() {
      return this.d;
   }

   public void a(String par1Str) {
      this.d = par1Str;
   }

   public boolean t_() {
      return this.i.a(this.j + 0.5, this.k + 0.5, this.l + 0.5, 16.0) != null;
   }

   @Override
   public void n_() {
      this.c = this.b;
      if (this.t_()) {
         double d = (double)this.j + this.i.r.nextFloat();
         double d1 = (double)this.k + this.i.r.nextFloat();
         double d2 = (double)this.l + this.i.r.nextFloat();
         this.i.a("smoke", d, d1, d2, 0.0, 0.0, 0.0);
         this.i.a("flame", d, d1, d2, 0.0, 0.0, 0.0);

         for (this.b = this.b + 1000.0F / (this.a + 200.0F); this.b > 360.0; this.c -= 360.0) {
            this.b -= 360.0;
         }

         if (!this.i.F) {
            if (this.a == -1) {
               this.d();
            }

            if (this.a > 0) {
               this.a--;
               return;
            }

            byte byte0 = 4;

            for (int i = 0; i < byte0; i++) {
               EntityLiving entityliving = (EntityLiving)EntityList.a(this.d, this.i);
               if (entityliving == null) {
                  return;
               }

               int j = this.i.a(entityliving.getClass(), AxisAlignedBB.b(this.j, this.k, this.l, this.j + 1L, this.k + 1, this.l + 1L).b(8.0, 4.0, 8.0)).size();
               if (j >= 6) {
                  this.d();
                  return;
               }

               double d3 = this.j + (this.i.r.nextDouble() - this.i.r.nextDouble()) * 4.0;
               double d4 = this.k + this.i.r.nextInt(3) - 1;
               double d5 = this.l + (this.i.r.nextDouble() - this.i.r.nextDouble()) * 4.0;
               entityliving.c(d3, d4, d5, this.i.r.nextFloat() * 360.0F, 0.0F);
               if (entityliving.i()) {
                  this.i.a(entityliving);
                  this.i.playAuxSFX(2004, this.j, this.k, this.l, 0);
                  entityliving.ba();
                  this.d();
               }
            }
         }

         super.n_();
      }
   }

   private void d() {
      this.a = 200 + this.i.r.nextInt(600);
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      this.d = par1NBTTagCompound.j("EntityId");
      this.a = par1NBTTagCompound.e("Delay");
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      par1NBTTagCompound.a("EntityId", this.d);
      par1NBTTagCompound.a("Delay", (short)this.a);
   }
}
