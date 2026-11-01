public class TileEntityChest extends TileEntity implements io {
   private ItemStack[] p = new ItemStack[36];
   public boolean a = false;
   public TileEntityChest b;
   public TileEntityChest c;
   public TileEntityChest d;
   public TileEntityChest e;
   public float f;
   public float g;
   public int h;
   private int q;

   public int a() {
      return 27;
   }

   public ItemStack k_(int par1) {
      return this.p[par1];
   }

   public ItemStack a(int par1, int par2) {
      if (this.p[par1] != null) {
         if (this.p[par1].a <= par2) {
            ItemStack itemstack = this.p[par1];
            this.p[par1] = null;
            this.j();
            return itemstack;
         }

         ItemStack itemstack1 = this.p[par1].a(par2);
         if (this.p[par1].a == 0) {
            this.p[par1] = null;
         }

         this.j();
         return itemstack1;
      } else {
         return null;
      }
   }

   public ItemStack b(int par1) {
      if (this.p[par1] != null) {
         ItemStack itemstack = this.p[par1];
         this.p[par1] = null;
         return itemstack;
      } else {
         return null;
      }
   }

   public void a(int par1, ItemStack par2ItemStack) {
      this.p[par1] = par2ItemStack;
      if (par2ItemStack != null && par2ItemStack.a > this.d()) {
         par2ItemStack.a = this.d();
      }

      this.j();
   }

   public String c() {
      return "container.chest";
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      no nbttaglist = par1NBTTagCompound.n("Items");
      this.p = new ItemStack[this.a()];

      for (int i = 0; i < nbttaglist.d(); i++) {
         ady nbttagcompound = (ady)nbttaglist.a(i);
         int j = nbttagcompound.d("Slot") & 255;
         if (j >= 0 && j < this.p.length) {
            this.p[j] = ItemStack.a(nbttagcompound);
         }
      }
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      no nbttaglist = new no();

      for (int i = 0; i < this.p.length; i++) {
         if (this.p[i] != null) {
            ady nbttagcompound = new ady();
            nbttagcompound.a("Slot", (byte)i);
            this.p[i].b(nbttagcompound);
            nbttaglist.a(nbttagcompound);
         }
      }

      par1NBTTagCompound.a("Items", nbttaglist);
   }

   public int d() {
      return 64;
   }

   public boolean a_(EntityPlayer par1EntityPlayer) {
      return this.i.getBlockTileEntity(this.j, this.k, this.l) != this ? false : par1EntityPlayer.f(this.j + 0.5, this.k + 0.5, this.l + 0.5) <= 64.0;
   }

   @Override
   public void b() {
      super.b();
      this.a = false;
   }

   public void g() {
      if (!this.a) {
         this.a = true;
         this.b = null;
         this.c = null;
         this.d = null;
         this.e = null;
         if (this.i.getBlockId(this.j - 1L, this.k, this.l) == Block.au.bO) {
            this.d = (TileEntityChest)this.i.getBlockTileEntity(this.j - 1L, this.k, this.l);
         }

         if (this.i.getBlockId(this.j + 1L, this.k, this.l) == Block.au.bO) {
            this.c = (TileEntityChest)this.i.getBlockTileEntity(this.j + 1L, this.k, this.l);
         }

         if (this.i.getBlockId(this.j, this.k, this.l - 1L) == Block.au.bO) {
            this.b = (TileEntityChest)this.i.getBlockTileEntity(this.j, this.k, this.l - 1L);
         }

         if (this.i.getBlockId(this.j, this.k, this.l + 1L) == Block.au.bO) {
            this.e = (TileEntityChest)this.i.getBlockTileEntity(this.j, this.k, this.l + 1L);
         }

         if (this.b != null) {
            this.b.b();
         }

         if (this.e != null) {
            this.e.b();
         }

         if (this.c != null) {
            this.c.b();
         }

         if (this.d != null) {
            this.d.b();
         }
      }
   }

   @Override
   public void n_() {
      super.n_();
      this.g();
      if (++this.q % 20 * 4 == 0) {
         this.i.playNoteAt(this.j, this.k, this.l, 1, this.h);
      }

      this.g = this.f;
      float f = 0.1F;
      if (this.h > 0 && this.f == 0.0F && this.b == null && this.d == null) {
         double d = this.j + 0.5;
         double d1 = this.l + 0.5;
         if (this.e != null) {
            d1 += 0.5;
         }

         if (this.c != null) {
            d += 0.5;
         }

         this.i.a(d, this.k + 0.5, d1, "random.chestopen", 0.5F, this.i.r.nextFloat() * 0.1F + 0.9F);
      }

      if (this.h == 0 && this.f > 0.0F || this.h > 0 && this.f < 1.0F) {
         float f1 = this.f;
         if (this.h > 0) {
            this.f += f;
         } else {
            this.f -= f;
         }

         if (this.f > 1.0F) {
            this.f = 1.0F;
         }

         float f2 = 0.5F;
         if (this.f < f2 && f1 >= f2 && this.b == null && this.d == null) {
            double d2 = this.j + 0.5;
            double d3 = this.l + 0.5;
            if (this.e != null) {
               d3 += 0.5;
            }

            if (this.c != null) {
               d2 += 0.5;
            }

            this.i.a(d2, this.k + 0.5, d3, "random.chestclosed", 0.5F, this.i.r.nextFloat() * 0.1F + 0.9F);
         }

         if (this.f < 0.0F) {
            this.f = 0.0F;
         }
      }
   }

   @Override
   public void b(int par1, int par2) {
      if (par1 == 1) {
         this.h = par2;
      }
   }

   public void e() {
      this.h++;
      this.i.playNoteAt(this.j, this.k, this.l, 1, this.h);
   }

   public void f() {
      this.h--;
      this.i.playNoteAt(this.j, this.k, this.l, 1, this.h);
   }

   @Override
   public void h() {
      this.b();
      this.g();
      super.h();
   }
}
