import java.util.List;
import java.util.Random;

public class ContainerEnchantment extends dd {
   public io a = new tj(this, "Enchant", 1);
   private World h;
   private long i;
   private int j;
   private long k;
   private Random l = new Random();
   public long b;
   public int[] c = new int[3];

   public ContainerEnchantment(aak par1InventoryPlayer, World par2World, long par3, int par4, long par5) {
      this.h = par2World;
      this.i = par3;
      this.j = par4;
      this.k = par5;
      this.a(new sl(this, this.a, 0, 25, 47));

      for (int i = 0; i < 3; i++) {
         for (int k = 0; k < 9; k++) {
            this.a(new yu(par1InventoryPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
         }
      }

      for (int j = 0; j < 9; j++) {
         this.a(new yu(par1InventoryPlayer, j, 8 + j * 18, 142));
      }
   }

   public void a() {
      super.a();

      for (int i = 0; i < this.g.size(); i++) {
         wm icrafting = (wm)this.g.get(i);
         icrafting.a(this, 0, this.c[0]);
         icrafting.a(this, 1, this.c[1]);
         icrafting.a(this, 2, this.c[2]);
      }
   }

   public void a(int par1, int par2) {
      if (par1 >= 0 && par1 <= 2) {
         this.c[par1] = par2;
      } else {
         super.a(par1, par2);
      }
   }

   public void a(io par1IInventory) {
      if (par1IInventory == this.a) {
         ItemStack itemstack = par1IInventory.k_(0);
         if (itemstack != null && itemstack.t()) {
            this.b = this.l.nextLong();
            if (!this.h.F) {
               int j = 0;

               for (int k = -1; k <= 1; k++) {
                  for (int i1 = -1; i1 <= 1; i1++) {
                     if ((k != 0 || i1 != 0) && this.h.isAirBlock(this.i + i1, this.j, this.k + k) && this.h.isAirBlock(this.i + i1, this.j + 1, this.k + k)) {
                        if (this.h.getBlockId(this.i + i1 * 2, this.j, this.k + k * 2) == Block.MapGenVillage.bO) {
                           j++;
                        }

                        if (this.h.getBlockId(this.i + i1 * 2, this.j + 1, this.k + k * 2) == Block.MapGenVillage.bO) {
                           j++;
                        }

                        if (i1 != 0 && k != 0) {
                           if (this.h.getBlockId(this.i + i1 * 2, this.j, this.k + k) == Block.MapGenVillage.bO) {
                              j++;
                           }

                           if (this.h.getBlockId(this.i + i1 * 2, this.j + 1, this.k + k) == Block.MapGenVillage.bO) {
                              j++;
                           }

                           if (this.h.getBlockId(this.i + i1, this.j, this.k + k * 2) == Block.MapGenVillage.bO) {
                              j++;
                           }

                           if (this.h.getBlockId(this.i + i1, this.j + 1, this.k + k * 2) == Block.MapGenVillage.bO) {
                              j++;
                           }
                        }
                     }
                  }
               }

               for (int l = 0; l < 3; l++) {
                  this.c[l] = ais.a(this.l, l, j, itemstack);
               }

               this.a();
            }
         } else {
            for (int i = 0; i < 3; i++) {
               this.c[i] = 0;
            }
         }
      }
   }

   public boolean a(EntityPlayer par1EntityPlayer, int par2) {
      ItemStack itemstack = this.a.k_(0);
      if (this.c[par2] > 0 && itemstack != null && (par1EntityPlayer.aU >= this.c[par2] || par1EntityPlayer.aT.d)) {
         if (!this.h.F) {
            List list = ais.b(this.l, itemstack, this.c[par2]);
            if (list != null) {
               par1EntityPlayer.j(this.c[par2]);

               for (lf enchantmentdata : list) {
                  itemstack.a(enchantmentdata.a, enchantmentdata.b);
               }

               this.a(this.a);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public void a(EntityPlayer par1EntityPlayer) {
      super.a(par1EntityPlayer);
      if (!this.h.F) {
         ItemStack itemstack = this.a.b(0);
         if (itemstack != null) {
            par1EntityPlayer.a(itemstack);
         }
      }
   }

   public boolean b(EntityPlayer par1EntityPlayer) {
      return this.h.getBlockId(this.i, this.j, this.k) != Block.bE.bO ? false : par1EntityPlayer.f(this.i + 0.5, this.j + 0.5, this.k + 0.5) <= 64.0;
   }

   public ItemStack a(int par1) {
      ItemStack itemstack = null;
      yu slot = (yu)this.e.get(par1);
      if (slot != null && slot.c()) {
         ItemStack itemstack1 = slot.b();
         itemstack = itemstack1.k();
         if (par1 != 0) {
            return null;
         }

         if (!this.a(itemstack1, 1, 37, true)) {
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
