public abstract class EntityMob extends EntityCreature implements xf {
   protected int c = 2;

   public EntityMob(World par1World) {
      super(par1World);
      this.bI = 5;
   }

   @Override
   public void e() {
      float f = this.a(1.0F);
      if (f > 0.5F) {
         this.cd += 2;
      }

      super.e();
   }

   @Override
   public void J_() {
      super.J_();
      if (!this.k.F && this.k.q == 0) {
         this.A();
      }
   }

   @Override
   protected Entity h() {
      EntityPlayer entityplayer = this.k.b(this, 16.0);
      return entityplayer != null && this.m(entityplayer) ? entityplayer : null;
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      if (super.a(par1DamageSource, par2)) {
         Entity entity = par1DamageSource.a();
         if (this.i != entity && this.j != entity) {
            if (entity != this) {
               this.GenLayerHills = entity;
            }

            return true;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   @Override
   public boolean c(Entity par1Entity) {
      int i = this.c;
      if (this.a(aad.g)) {
         i += 3 << this.b(aad.g).c();
      }

      if (this.a(aad.t)) {
         i -= 2 << this.b(aad.t).c();
      }

      return par1Entity.a(md.a(this), i);
   }

   @Override
   protected void a(Entity par1Entity, float par2) {
      if (this.bE <= 0 && par2 < 2.0F && par1Entity.y.e > this.y.b && par1Entity.y.b < this.y.e) {
         this.bE = 20;
         this.c(par1Entity);
      }
   }

   @Override
   public float getBlockPathWeight(long par1, int par2, long par3) {
      return 0.5F - this.k.getLightBrightness(par1, par2, par3);
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
   }

   protected boolean BlockSnowBlock() {
      long i = MathHelper.d(this.o);
      int j = MathHelper.c(this.y.b);
      long k = MathHelper.d(this.q);
      if (this.k.getSavedLightValue(wl.a, i, j, k) > this.U.nextInt(32)) {
         return false;
      }

      int l = this.k.getBlockLightValue(i, j, k);
      if (this.k.F()) {
         int i1 = this.k.f;
         this.k.f = 10;
         l = this.k.getBlockLightValue(i, j, k);
         this.k.f = i1;
      }

      return l <= this.U.nextInt(8);
   }

   @Override
   public boolean i() {
      return this.BlockSnowBlock() && super.i();
   }
}
