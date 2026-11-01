import java.util.Random;

public class BlockChest extends BlockContainer {
   private Random a = new Random();

   protected BlockChest(int par1) {
      super(par1, acn.d);
      this.bN = 26;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public int d() {
      return 22;
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      super.onBlockAdded(par1World, par2, par3, par4);
      this.unifyAdjacentChests(par1World, par2, par3, par4);
      int i = par1World.getBlockId(par2, par3, par4 - 1L);
      int j = par1World.getBlockId(par2, par3, par4 + 1L);
      int k = par1World.getBlockId(par2 - 1L, par3, par4);
      int l = par1World.getBlockId(par2 + 1L, par3, par4);
      if (i == this.bO) {
         this.unifyAdjacentChests(par1World, par2, par3, par4 - 1L);
      }

      if (j == this.bO) {
         this.unifyAdjacentChests(par1World, par2, par3, par4 + 1L);
      }

      if (k == this.bO) {
         this.unifyAdjacentChests(par1World, par2 - 1L, par3, par4);
      }

      if (l == this.bO) {
         this.unifyAdjacentChests(par1World, par2 + 1L, par3, par4);
      }
   }

   @Override
   public void onBlockPlacedBy(World par1World, long par2, int par3, long par4, EntityLiving par5EntityLiving) {
      int i = par1World.getBlockId(par2, par3, par4 - 1L);
      int j = par1World.getBlockId(par2, par3, par4 + 1L);
      int k = par1World.getBlockId(par2 - 1L, par3, par4);
      int l = par1World.getBlockId(par2 + 1L, par3, par4);
      byte byte0 = 0;
      int i1 = MathHelper.c(par5EntityLiving.u * 4.0F / 360.0F + 0.5) & 3;
      if (i1 == 0) {
         byte0 = 2;
      }

      if (i1 == 1) {
         byte0 = 5;
      }

      if (i1 == 2) {
         byte0 = 3;
      }

      if (i1 == 3) {
         byte0 = 4;
      }

      if (i != this.bO && j != this.bO && k != this.bO && l != this.bO) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0);
      } else {
         if ((i == this.bO || j == this.bO) && (byte0 == 4 || byte0 == 5)) {
            if (i == this.bO) {
               par1World.setBlockMetadataWithNotify(par2, par3, par4 - 1L, byte0);
            } else {
               par1World.setBlockMetadataWithNotify(par2, par3, par4 + 1L, byte0);
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0);
         }

         if ((k == this.bO || l == this.bO) && (byte0 == 2 || byte0 == 3)) {
            if (k == this.bO) {
               par1World.setBlockMetadataWithNotify(par2 - 1L, par3, par4, byte0);
            } else {
               par1World.setBlockMetadataWithNotify(par2 + 1L, par3, par4, byte0);
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0);
         }
      }
   }

   public void unifyAdjacentChests(World par1World, long par2, int par3, long par4) {
      if (!par1World.F) {
         int i = par1World.getBlockId(par2, par3, par4 - 1L);
         int j = par1World.getBlockId(par2, par3, par4 + 1L);
         int k = par1World.getBlockId(par2 - 1L, par3, par4);
         int l = par1World.getBlockId(par2 + 1L, par3, par4);
         byte byte0 = 4;
         if (i == this.bO || j == this.bO) {
            int i1 = par1World.getBlockId(par2 - 1L, par3, i != this.bO ? par4 + 1L : par4 - 1L);
            int k1 = par1World.getBlockId(par2 + 1L, par3, i != this.bO ? par4 + 1L : par4 - 1L);
            byte0 = 5;
            int i2 = -1;
            if (i == this.bO) {
               i2 = par1World.getBlockMetadata(par2, par3, par4 - 1L);
            } else {
               i2 = par1World.getBlockMetadata(par2, par3, par4 + 1L);
            }

            if (i2 == 4) {
               byte0 = 4;
            }

            if ((Block.n[k] || Block.n[i1]) && !Block.n[l] && !Block.n[k1]) {
               byte0 = 5;
            }

            if ((Block.n[l] || Block.n[k1]) && !Block.n[k] && !Block.n[i1]) {
               byte0 = 4;
            }
         } else if (k != this.bO && l != this.bO) {
            byte0 = 3;
            if (Block.n[i] && !Block.n[j]) {
               byte0 = 3;
            }

            if (Block.n[j] && !Block.n[i]) {
               byte0 = 2;
            }

            if (Block.n[k] && !Block.n[l]) {
               byte0 = 5;
            }

            if (Block.n[l] && !Block.n[k]) {
               byte0 = 4;
            }
         } else {
            int j1 = par1World.getBlockId(k != this.bO ? par2 + 1L : par2 - 1L, par3, par4 - 1L);
            int l1 = par1World.getBlockId(k != this.bO ? par2 + 1L : par2 - 1L, par3, par4 + 1L);
            byte0 = 3;
            int j2 = -1;
            if (k == this.bO) {
               j2 = par1World.getBlockMetadata(par2 - 1L, par3, par4);
            } else {
               j2 = par1World.getBlockMetadata(par2 + 1L, par3, par4);
            }

            if (j2 == 2) {
               byte0 = 2;
            }

            if ((Block.n[i] || Block.n[j1]) && !Block.n[j] && !Block.n[l1]) {
               byte0 = 3;
            }

            if ((Block.n[j] || Block.n[l1]) && !Block.n[i] && !Block.n[j1]) {
               byte0 = 2;
            }
         }

         par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0);
      }
   }

   @Override
   public int getBlockTexture(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      if (par5 == 1) {
         return this.bN - 1;
      }

      if (par5 == 0) {
         return this.bN - 1;
      }

      int i = par1IBlockAccess.getBlockId(par2, par3, par4 - 1L);
      int j = par1IBlockAccess.getBlockId(par2, par3, par4 + 1L);
      int k = par1IBlockAccess.getBlockId(par2 - 1L, par3, par4);
      int l = par1IBlockAccess.getBlockId(par2 + 1L, par3, par4);
      if (i != this.bO && j != this.bO) {
         if (k != this.bO && l != this.bO) {
            byte byte0 = 3;
            if (Block.n[i] && !Block.n[j]) {
               byte0 = 3;
            }

            if (Block.n[j] && !Block.n[i]) {
               byte0 = 2;
            }

            if (Block.n[k] && !Block.n[l]) {
               byte0 = 5;
            }

            if (Block.n[l] && !Block.n[k]) {
               byte0 = 4;
            }

            return par5 != byte0 ? this.bN : this.bN + 1;
         } else if (par5 != 4 && par5 != 5) {
            int j1 = 0;
            if (k == this.bO) {
               j1 = -1;
            }

            int l1 = par1IBlockAccess.getBlockId(k != this.bO ? par2 + 1L : par2 - 1L, par3, par4 - 1L);
            int j2 = par1IBlockAccess.getBlockId(k != this.bO ? par2 + 1L : par2 - 1L, par3, par4 + 1L);
            if (par5 == 3) {
               j1 = -1 - j1;
            }

            byte byte2 = 3;
            if ((Block.n[i] || Block.n[l1]) && !Block.n[j] && !Block.n[j2]) {
               byte2 = 3;
            }

            if ((Block.n[j] || Block.n[j2]) && !Block.n[i] && !Block.n[l1]) {
               byte2 = 2;
            }

            return (par5 != byte2 ? this.bN + 32 : this.bN + 16) + j1;
         } else {
            return this.bN;
         }
      } else if (par5 != 2 && par5 != 3) {
         int i1 = 0;
         if (i == this.bO) {
            i1 = -1;
         }

         int k1 = par1IBlockAccess.getBlockId(par2 - 1L, par3, i != this.bO ? par4 + 1L : par4 - 1L);
         int i2 = par1IBlockAccess.getBlockId(par2 + 1L, par3, i != this.bO ? par4 + 1L : par4 - 1L);
         if (par5 == 4) {
            i1 = -1 - i1;
         }

         byte byte1 = 5;
         if ((Block.n[k] || Block.n[k1]) && !Block.n[l] && !Block.n[i2]) {
            byte1 = 5;
         }

         if ((Block.n[l] || Block.n[i2]) && !Block.n[k] && !Block.n[k1]) {
            byte1 = 4;
         }

         return (par5 != byte1 ? this.bN + 32 : this.bN + 16) + i1;
      } else {
         return this.bN;
      }
   }

   @Override
   public int a_(int par1) {
      if (par1 == 1) {
         return this.bN - 1;
      } else if (par1 == 0) {
         return this.bN - 1;
      } else {
         return par1 == 3 ? this.bN + 1 : this.bN;
      }
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      int i = 0;
      if (par1World.getBlockId(par2 - 1L, par3, par4) == this.bO) {
         i++;
      }

      if (par1World.getBlockId(par2 + 1L, par3, par4) == this.bO) {
         i++;
      }

      if (par1World.getBlockId(par2, par3, par4 - 1L) == this.bO) {
         i++;
      }

      if (par1World.getBlockId(par2, par3, par4 + 1L) == this.bO) {
         i++;
      }

      if (i > 1) {
         return false;
      } else if (this.isThereANeighborChest(par1World, par2 - 1L, par3, par4)) {
         return false;
      } else if (this.isThereANeighborChest(par1World, par2 + 1L, par3, par4)) {
         return false;
      } else {
         return this.isThereANeighborChest(par1World, par2, par3, par4 - 1L) ? false : !this.isThereANeighborChest(par1World, par2, par3, par4 + 1L);
      }
   }

   private boolean isThereANeighborChest(World par1World, long par2, int par3, long par4) {
      if (par1World.getBlockId(par2, par3, par4) != this.bO) {
         return false;
      } else if (par1World.getBlockId(par2 - 1L, par3, par4) == this.bO) {
         return true;
      } else if (par1World.getBlockId(par2 + 1L, par3, par4) == this.bO) {
         return true;
      } else {
         return par1World.getBlockId(par2, par3, par4 - 1L) == this.bO ? true : par1World.getBlockId(par2, par3, par4 + 1L) == this.bO;
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
      TileEntityChest tileentitychest = (TileEntityChest)par1World.getBlockTileEntity(par2, par3, par4);
      if (tileentitychest != null) {
         tileentitychest.b();
      }
   }

   @Override
   public void onBlockRemoval(World par1World, long par2, int par3, long par4) {
      TileEntityChest tileentitychest = (TileEntityChest)par1World.getBlockTileEntity(par2, par3, par4);
      if (tileentitychest != null) {
         for (int i = 0; i < tileentitychest.a(); i++) {
            ItemStack itemstack = tileentitychest.k_(i);
            if (itemstack != null) {
               double f = this.a.nextFloat() * 0.8F + 0.1F;
               double f1 = this.a.nextFloat() * 0.8F + 0.1F;
               double f2 = this.a.nextFloat() * 0.8F + 0.1F;

               while (itemstack.a > 0) {
                  int j = this.a.nextInt(21) + 10;
                  if (j > itemstack.a) {
                     j = itemstack.a;
                  }

                  itemstack.a -= j;
                  EntityItem entityitem = new EntityItem(par1World, par2 + f, par3 + f1, par4 + f2, new ItemStack(itemstack.c, j, itemstack.i()));
                  float f3 = 0.05F;
                  entityitem.r = (float)this.a.nextGaussian() * f3;
                  entityitem.s = (float)this.a.nextGaussian() * f3 + 0.2F;
                  entityitem.t = (float)this.a.nextGaussian() * f3;
                  if (itemstack.n()) {
                     entityitem.a.d((ady)itemstack.o().b());
                  }

                  par1World.a(entityitem);
               }
            }
         }
      }

      super.onBlockRemoval(par1World, par2, par3, par4);
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      Object obj = (TileEntityChest)par1World.getBlockTileEntity(par2, par3, par4);
      if (obj == null) {
         return true;
      }

      if (par1World.isBlockNormalCube(par2, par3 + 1, par4)) {
         return true;
      }

      if (func_50075_j(par1World, par2, par3, par4)) {
         return true;
      }

      if (par1World.getBlockId(par2 - 1L, par3, par4) != this.bO
         || !par1World.isBlockNormalCube(par2 - 1L, par3 + 1, par4) && !func_50075_j(par1World, par2 - 1L, par3, par4)) {
         if (par1World.getBlockId(par2 + 1L, par3, par4) != this.bO
            || !par1World.isBlockNormalCube(par2 + 1L, par3 + 1, par4) && !func_50075_j(par1World, par2 + 1L, par3, par4)) {
            if (par1World.getBlockId(par2, par3, par4 - 1L) != this.bO
               || !par1World.isBlockNormalCube(par2, par3 + 1, par4 - 1L) && !func_50075_j(par1World, par2, par3, par4 - 1L)) {
               if (par1World.getBlockId(par2, par3, par4 + 1L) != this.bO
                  || !par1World.isBlockNormalCube(par2, par3 + 1, par4 + 1L) && !func_50075_j(par1World, par2, par3, par4 + 1L)) {
                  if (par1World.getBlockId(par2 - 1L, par3, par4) == this.bO) {
                     obj = new kl("Large chest", (TileEntityChest)par1World.getBlockTileEntity(par2 - 1L, par3, par4), (io)obj);
                  }

                  if (par1World.getBlockId(par2 + 1L, par3, par4) == this.bO) {
                     obj = new kl("Large chest", (io)obj, (TileEntityChest)par1World.getBlockTileEntity(par2 + 1L, par3, par4));
                  }

                  if (par1World.getBlockId(par2, par3, par4 - 1L) == this.bO) {
                     obj = new kl("Large chest", (TileEntityChest)par1World.getBlockTileEntity(par2, par3, par4 - 1L), (io)obj);
                  }

                  if (par1World.getBlockId(par2, par3, par4 + 1L) == this.bO) {
                     obj = new kl("Large chest", (io)obj, (TileEntityChest)par1World.getBlockTileEntity(par2, par3, par4 + 1L));
                  }

                  if (par1World.F) {
                     return true;
                  }

                  par5EntityPlayer.a((io & io)obj);
                  return true;
               } else {
                  return true;
               }
            } else {
               return true;
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   @Override
   public TileEntity u_() {
      return new TileEntityChest();
   }

   private static boolean func_50075_j(World par0World, long par1, int par2, long par3) {
      for (Entity entity : par0World.a(EntityOcelot.class, AxisAlignedBB.b(par1, par2 + 1, par3, par1 + 1L, par2 + 2, par3 + 1L))) {
         EntityOcelot entityocelot = (EntityOcelot)entity;
         if (entityocelot.TileEntityMobSpawnerRenderer()) {
            return true;
         }
      }

      return false;
   }
}
