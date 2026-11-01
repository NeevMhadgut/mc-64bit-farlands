import java.util.List;

public class TileEntityBrewingStand extends TileEntity implements io {
   private ItemStack[] a = new ItemStack[4];
   private int b;
   private int c;
   private int d;

   public String c() {
      return "container.brewing";
   }

   public int a() {
      return this.a.length;
   }

   @Override
   public void n_() {
      if (this.b > 0) {
         this.b--;
         if (this.b == 0) {
            this.p();
            this.j();
         } else if (!this.o()) {
            this.b = 0;
            this.j();
         } else if (this.d != this.a[3].c) {
            this.b = 0;
            this.j();
         }
      } else if (this.o()) {
         this.b = 400;
         this.d = this.a[3].c;
      }

      int i = this.n();
      if (i != this.c) {
         this.c = i;
         this.i.setBlockMetadataWithNotify(this.j, this.k, this.l, i);
      }

      super.n_();
   }

   public int g() {
      return this.b;
   }

   private boolean o() {
      if (this.a[3] != null && this.a[3].a > 0) {
         ItemStack itemstack = this.a[3];
         if (!Item.e[itemstack.c].p()) {
            return false;
         }

         boolean flag = false;

         for (int i = 0; i < 3; i++) {
            if (this.a[i] != null && this.a[i].c == Item.bs.bQ) {
               int j = this.a[i].i();
               int k = this.b(j, itemstack);
               if (!ei.c(j) && ei.c(k)) {
                  flag = true;
                  break;
               }

               List list = Item.bs.e_(j);
               List list1 = Item.bs.e_(k);
               if ((j <= 0 || list != list1) && (list == null || !list.equals(list1) && list1 != null) && j != k) {
                  flag = true;
                  break;
               }
            }
         }

         return flag;
      } else {
         return false;
      }
   }

   private void p() {
      if (this.o()) {
         ItemStack itemstack = this.a[3];

         for (int i = 0; i < 3; i++) {
            if (this.a[i] != null && this.a[i].c == Item.bs.bQ) {
               int j = this.a[i].i();
               int k = this.b(j, itemstack);
               List list = Item.bs.e_(j);
               List list1 = Item.bs.e_(k);
               if (j > 0 && list == list1 || list != null && (list.equals(list1) || list1 == null)) {
                  if (!ei.c(j) && ei.c(k)) {
                     this.a[i].b(k);
                  }
               } else if (j != k) {
                  this.a[i].b(k);
               }
            }
         }

         if (Item.e[itemstack.c].m()) {
            this.a[3] = new ItemStack(Item.e[itemstack.c].l());
         } else {
            this.a[3].a--;
            if (this.a[3].a <= 0) {
               this.a[3] = null;
            }
         }
      }
   }

   private int b(int par1, ItemStack par2ItemStack) {
      if (par2ItemStack == null) {
         return par1;
      } else {
         return Item.e[par2ItemStack.c].p() ? hx.a(par1, Item.e[par2ItemStack.c].o()) : par1;
      }
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      no nbttaglist = par1NBTTagCompound.n("Items");
      this.a = new ItemStack[this.a()];

      for (int i = 0; i < nbttaglist.d(); i++) {
         ady nbttagcompound = (ady)nbttaglist.a(i);
         byte byte0 = nbttagcompound.d("Slot");
         if (byte0 >= 0 && byte0 < this.a.length) {
            this.a[byte0] = ItemStack.a(nbttagcompound);
         }
      }

      this.b = par1NBTTagCompound.e("BrewTime");
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
      par1NBTTagCompound.a("BrewTime", (short)this.b);
      no nbttaglist = new no();

      for (int i = 0; i < this.a.length; i++) {
         if (this.a[i] != null) {
            ady nbttagcompound = new ady();
            nbttagcompound.a("Slot", (byte)i);
            this.a[i].b(nbttagcompound);
            nbttaglist.a(nbttagcompound);
         }
      }

      par1NBTTagCompound.a("Items", nbttaglist);
   }

   public ItemStack k_(int par1) {
      return par1 >= 0 && par1 < this.a.length ? this.a[par1] : null;
   }

   public ItemStack a(int par1, int par2) {
      if (par1 >= 0 && par1 < this.a.length) {
         ItemStack itemstack = this.a[par1];
         this.a[par1] = null;
         return itemstack;
      } else {
         return null;
      }
   }

   public ItemStack b(int par1) {
      if (par1 >= 0 && par1 < this.a.length) {
         ItemStack itemstack = this.a[par1];
         this.a[par1] = null;
         return itemstack;
      } else {
         return null;
      }
   }

   public void a(int par1, ItemStack par2ItemStack) {
      if (par1 >= 0 && par1 < this.a.length) {
         this.a[par1] = par2ItemStack;
      }
   }

   public int d() {
      return 1;
   }

   public boolean a_(EntityPlayer par1EntityPlayer) {
      return this.i.getBlockTileEntity(this.j, this.k, this.l) != this ? false : par1EntityPlayer.f(this.j + 0.5, this.k + 0.5, this.l + 0.5) <= 64.0;
   }

   public void e() {
   }

   public void f() {
   }

   public void c(int par1) {
      this.b = par1;
   }

   public int n() {
      int i = 0;

      for (int j = 0; j < 3; j++) {
         if (this.a[j] != null) {
            i |= 1 << j;
         }
      }

      return i;
   }
}
