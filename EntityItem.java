public class EntityItem extends Entity {
   public ItemStack a;
   public int b = 0;
   public int c;
   private int e = 5;
   public float d = (float)(Math.random() * Math.PI * 2.0);

   public EntityItem(World par1World, double par2, double par4, double par6, ItemStack par8ItemStack) {
      super(par1World);
      this.a(0.25F, 0.25F);
      this.H = this.J / 2.0F;
      this.d(par2, par4, par6);
      this.a = par8ItemStack;
      this.u = (float)(Math.random() * 360.0);
      this.r = (float)(Math.random() * 0.2F - 0.1F);
      this.s = 0.2F;
      this.t = (float)(Math.random() * 0.2F - 0.1F);
   }

   @Override
   protected boolean e_() {
      return false;
   }

   public EntityItem(World par1World) {
      super(par1World);
      this.a(0.25F, 0.25F);
      this.H = this.J / 2.0F;
   }

   @Override
   protected void b() {
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
      this.s -= 0.04F;
      if (this.k.getBlockMaterial(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q)) == acn.h) {
         this.s = 0.2F;
         this.r = (this.U.nextFloat() - this.U.nextFloat()) * 0.2F;
         this.t = (this.U.nextFloat() - this.U.nextFloat()) * 0.2F;
         this.k.a(this, "random.fizz", 0.4F, 2.0F + this.U.nextFloat() * 0.4F);
      }

      this.h(this.o, (this.y.b + this.y.e) / 2.0, this.q);
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
         this.s *= -0.5;
      }

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
      this.e -= par2;
      if (this.e <= 0) {
         this.A();
      }

      return false;
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      par1NBTTagCompound.a("Health", (byte)this.e);
      par1NBTTagCompound.a("Age", (short)this.b);
      par1NBTTagCompound.a("Item", this.a.b(new ady()));
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      this.e = par1NBTTagCompound.e("Health") & 255;
      this.b = par1NBTTagCompound.e("Age");
      ady nbttagcompound = par1NBTTagCompound.m("Item");
      this.a = ItemStack.a(nbttagcompound);
      if (this.a == null) {
         this.A();
      }
   }

   @Override
   public void a(EntityPlayer par1EntityPlayer) {
      if (!this.k.F) {
         int i = this.a.a;
         if (this.c == 0 && par1EntityPlayer.ap.a(this.a)) {
            if (this.a.c == Block.J.bO) {
               par1EntityPlayer.a(dp.g);
            }

            if (this.a.c == Item.aF.bQ) {
               par1EntityPlayer.a(dp.t);
            }

            if (this.a.c == Item.n.bQ) {
               par1EntityPlayer.a(dp.w);
            }

            if (this.a.c == Item.bo.bQ) {
               par1EntityPlayer.a(dp.z);
            }

            this.k.a(this, "random.pop", 0.2F, ((this.U.nextFloat() - this.U.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            par1EntityPlayer.b(this, i);
            if (this.a.a <= 0) {
               this.A();
            }
         }
      }
   }

   @Override
   public boolean k_() {
      return false;
   }
}
