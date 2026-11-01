public class TileEntityFurnace extends TileEntity implements io {
   private ItemStack[] d = new ItemStack[3];
   public int a = 0;
   public int b = 0;
   public int c = 0;

   public int a() {
      return this.d.length;
   }

   public ItemStack k_(int par1) {
      return this.d[par1];
   }

   public ItemStack a(int par1, int par2) {
      if (this.d[par1] != null) {
         if (this.d[par1].a <= par2) {
            ItemStack itemstack = this.d[par1];
            this.d[par1] = null;
            return itemstack;
         }

         ItemStack itemstack1 = this.d[par1].a(par2);
         if (this.d[par1].a == 0) {
            this.d[par1] = null;
         }

         return itemstack1;
      } else {
         return null;
      }
   }

   public ItemStack b(int par1) {
      if (this.d[par1] != null) {
         ItemStack itemstack = this.d[par1];
         this.d[par1] = null;
         return itemstack;
      } else {
         return null;
      }
   }

   public void a(int par1, ItemStack par2ItemStack) {
      this.d[par1] = par2ItemStack;
      if (par2ItemStack != null && par2ItemStack.a > this.d()) {
         par2ItemStack.a = this.d();
      }
   }

   public String c() {
      return "container.furnace";
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      no nbttaglist = par1NBTTagCompound.n("Items");
      this.d = new ItemStack[this.a()];

      for (int i = 0; i < nbttaglist.d(); i++) {
         ady nbttagcompound = (ady)nbttaglist.a(i);
         byte byte0 = nbttagcompound.d("Slot");
         if (byte0 >= 0 && byte0 < this.d.length) {
            this.d[byte0] = ItemStack.a(nbttagcompound);
         }
      }

      this.a = par1NBTTagCompound.e("BurnTime");
      this.c = par1NBTTagCompound.e("CookTime");
      this.b = a(this.d[1]);
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      par1NBTTagCompound.a("BurnTime", (short)this.a);
      par1NBTTagCompound.a("CookTime", (short)this.c);
      no nbttaglist = new no();

      for (int i = 0; i < this.d.length; i++) {
         if (this.d[i] != null) {
            ady nbttagcompound = new ady();
            nbttagcompound.a("Slot", (byte)i);
            this.d[i].b(nbttagcompound);
            nbttaglist.a(nbttagcompound);
         }
      }

      par1NBTTagCompound.a("Items", nbttaglist);
   }

   public int d() {
      return 64;
   }

   public int c(int par1) {
      return this.c * par1 / 200;
   }

   public int d(int par1) {
      if (this.b == 0) {
         this.b = 200;
      }

      return this.a * par1 / this.b;
   }

   public boolean g() {
      return this.a > 0;
   }

   @Override
   public void n_() {
      boolean flag = this.a > 0;
      boolean flag1 = false;
      if (this.a > 0) {
         this.a--;
      }

      if (!this.i.F) {
         if (this.a == 0 && this.o()) {
            this.b = this.a = a(this.d[1]);
            if (this.a > 0) {
               flag1 = true;
               if (this.d[1] != null) {
                  this.d[1].a--;
                  if (this.d[1].a == 0) {
                     this.d[1] = null;
                  }
               }
            }
         }

         if (this.g() && this.o()) {
            this.c++;
            if (this.c == 200) {
               this.c = 0;
               this.n();
               flag1 = true;
            }
         } else {
            this.c = 0;
         }

         if (flag != this.a > 0) {
            flag1 = true;
            BlockFurnace.updateFurnaceBlockState(this.a > 0, this.i, this.j, this.k, this.l);
         }
      }

      if (flag1) {
         this.j();
      }
   }

   private boolean o() {
      if (this.d[0] == null) {
         return false;
      } else {
         ItemStack itemstack = dy.a().a(this.d[0].a().bQ);
         if (itemstack == null) {
            return false;
         } else if (this.d[2] == null) {
            return true;
         } else if (!this.d[2].a(itemstack)) {
            return false;
         } else {
            return this.d[2].a < this.d() && this.d[2].a < this.d[2].c() ? true : this.d[2].a < itemstack.c();
         }
      }
   }

   public void n() {
      if (this.o()) {
         ItemStack itemstack = dy.a().a(this.d[0].a().bQ);
         if (this.d[2] == null) {
            this.d[2] = itemstack.k();
         } else if (this.d[2].c == itemstack.c) {
            this.d[2].a++;
         }

         this.d[0].a--;
         if (this.d[0].a <= 0) {
            this.d[0] = null;
         }
      }
   }

   public static int a(ItemStack par1ItemStack) {
      if (par1ItemStack == null) {
         return 0;
      } else {
         int i = par1ItemStack.a().bQ;
         if (i < 256 && Block.m[i].cd == acn.d) {
            return 300;
         } else if (i == Item.D.bQ) {
            return 100;
         } else if (i == Item.m.bQ) {
            return 1600;
         } else if (i == Item.StructureNetherBridgeStart.bQ) {
            return 20000;
         } else if (i == Block.y.bO) {
            return 100;
         } else {
            return i != Item.bo.bQ ? 0 : 2400;
         }
      }
   }

   public static boolean b(ItemStack par0ItemStack) {
      return a(par0ItemStack) > 0;
   }

   public boolean a_(EntityPlayer par1EntityPlayer) {
      return this.i.getBlockTileEntity(this.j, this.k, this.l) != this ? false : par1EntityPlayer.f(this.j + 0.5, this.k + 0.5, this.l + 0.5) <= 64.0;
   }

   public void e() {
   }

   public void f() {
   }
}
