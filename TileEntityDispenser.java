import java.util.Random;

public class TileEntityDispenser extends TileEntity implements io {
   private ItemStack[] a = new ItemStack[9];
   private Random b = new Random();

   public int a() {
      return 9;
   }

   public ItemStack k_(int par1) {
      return this.a[par1];
   }

   public ItemStack a(int par1, int par2) {
      if (this.a[par1] != null) {
         if (this.a[par1].a <= par2) {
            ItemStack itemstack = this.a[par1];
            this.a[par1] = null;
            this.j();
            return itemstack;
         }

         ItemStack itemstack1 = this.a[par1].a(par2);
         if (this.a[par1].a == 0) {
            this.a[par1] = null;
         }

         this.j();
         return itemstack1;
      } else {
         return null;
      }
   }

   public ItemStack b(int par1) {
      if (this.a[par1] != null) {
         ItemStack itemstack = this.a[par1];
         this.a[par1] = null;
         return itemstack;
      } else {
         return null;
      }
   }

   public ItemStack m_() {
      int i = -1;
      int j = 1;

      for (int k = 0; k < this.a.length; k++) {
         if (this.a[k] != null && this.b.nextInt(j++) == 0) {
            i = k;
         }
      }

      return i >= 0 ? this.a(i, 1) : null;
   }

   public void a(int par1, ItemStack par2ItemStack) {
      this.a[par1] = par2ItemStack;
      if (par2ItemStack != null && par2ItemStack.a > this.d()) {
         par2ItemStack.a = this.d();
      }

      this.j();
   }

   public String c() {
      return "container.dispenser";
   }

   @Override
   public void a(ady par1NBTTagCompound) {
      super.a(par1NBTTagCompound);
      no nbttaglist = par1NBTTagCompound.n("Items");
      this.a = new ItemStack[this.a()];

      for (int i = 0; i < nbttaglist.d(); i++) {
         ady nbttagcompound = (ady)nbttaglist.a(i);
         int j = nbttagcompound.d("Slot") & 255;
         if (j >= 0 && j < this.a.length) {
            this.a[j] = ItemStack.a(nbttagcompound);
         }
      }
   }

   @Override
   public void b(ady par1NBTTagCompound) {
      super.b(par1NBTTagCompound);
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

   public int d() {
      return 64;
   }

   public boolean a_(EntityPlayer par1EntityPlayer) {
      return this.i.getBlockTileEntity(this.j, this.k, this.l) != this ? false : par1EntityPlayer.f(this.j + 0.5, this.k + 0.5, this.l + 0.5) <= 64.0;
   }

   public void e() {
   }

   public void f() {
   }
}
