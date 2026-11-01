public class ContainerWorkbench extends dd {
   public ade a = new ade(this, 3, 3);
   public io b = new akk();
   private World c;
   private long h;
   private int i;
   private long j;

   public ContainerWorkbench(aak par1InventoryPlayer, World par2World, long par3, int par4, long par5) {
      this.c = par2World;
      this.h = par3;
      this.i = par4;
      this.j = par5;
      this.a(new amn(par1InventoryPlayer.d, this.a, this.b, 0, 124, 35));

      for (int i = 0; i < 3; i++) {
         for (int l = 0; l < 3; l++) {
            this.a(new yu(this.a, l + i * 3, 30 + l * 18, 17 + i * 18));
         }
      }

      for (int j = 0; j < 3; j++) {
         for (int i1 = 0; i1 < 9; i1++) {
            this.a(new yu(par1InventoryPlayer, i1 + j * 9 + 9, 8 + i1 * 18, 84 + j * 18));
         }
      }

      for (int k = 0; k < 9; k++) {
         this.a(new yu(par1InventoryPlayer, k, 8 + k * 18, 142));
      }

      this.a(this.a);
   }

   public void a(io par1IInventory) {
      this.b.a(0, fr.a().a(this.a));
   }

   public void a(EntityPlayer par1EntityPlayer) {
      super.a(par1EntityPlayer);
      if (!this.c.F) {
         for (int i = 0; i < 9; i++) {
            ItemStack itemstack = this.a.b(i);
            if (itemstack != null) {
               par1EntityPlayer.a(itemstack);
            }
         }
      }
   }

   public boolean b(EntityPlayer par1EntityPlayer) {
      return this.c.getBlockId(this.h, this.i, this.j) != Block.StructureNetherBridgeStart.bO ? false : par1EntityPlayer.f(this.h + 0.5, this.i + 0.5, this.j + 0.5) <= 64.0;
   }

   public ItemStack a(int par1) {
      ItemStack itemstack = null;
      yu slot = (yu)this.e.get(par1);
      if (slot != null && slot.c()) {
         ItemStack itemstack1 = slot.b();
         itemstack = itemstack1.k();
         if (par1 == 0) {
            if (!this.a(itemstack1, 10, 46, true)) {
               return null;
            }

            slot.a(itemstack1, itemstack);
         } else if (par1 >= 10 && par1 < 37) {
            if (!this.a(itemstack1, 37, 46, false)) {
               return null;
            }
         } else if (par1 >= 37 && par1 < 46) {
            if (!this.a(itemstack1, 10, 37, false)) {
               return null;
            }
         } else if (!this.a(itemstack1, 10, 46, false)) {
            return null;
         }

         if (itemstack1.a == 0) {
            slot.d(null);
         } else {
            slot.d();
         }

         if (itemstack1.a == itemstack.a) {
            return null;
         }

         slot.b(itemstack1);
      }

      return itemstack;
   }
}
