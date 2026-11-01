import java.util.Random;

public class BlockFurnace extends BlockContainer {
   private Random a = new Random();
   private final boolean b;
   private static boolean c = false;

   protected BlockFurnace(int par1, boolean par2) {
      super(par1, acn.e);
      this.b = par2;
      this.bN = 45;
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Block.aB.bO;
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      super.onBlockAdded(par1World, par2, par3, par4);
      this.setDefaultDirection(par1World, par2, par3, par4);
   }

   private void setDefaultDirection(World par1World, long par2, int par3, long par4) {
      if (!par1World.F) {
         int i = par1World.getBlockId(par2, par3, par4 - 1L);
         int j = par1World.getBlockId(par2, par3, par4 + 1L);
         int k = par1World.getBlockId(par2 - 1L, par3, par4);
         int l = par1World.getBlockId(par2 + 1L, par3, par4);
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

         par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0);
      }
   }

   @Override
   public int getBlockTexture(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      if (par5 == 1) {
         return this.bN + 17;
      } else if (par5 == 0) {
         return this.bN + 17;
      } else {
         int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
         if (par5 != i) {
            return this.bN;
         } else {
            return this.b ? this.bN + 16 : this.bN - 1;
         }
      }
   }

   @Override
   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (this.b) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         double f = par2 + 0.5;
         double f1 = (double)par3 + par5Random.nextFloat() * 6.0F / 16.0F;
         double f2 = par4 + 0.5;
         double f3 = 0.52;
         double f4 = par5Random.nextFloat() * 0.6F - 0.3F;
         if (i == 4) {
            par1World.a("smoke", f - f3, f1, f2 + f4, 0.0, 0.0, 0.0);
            par1World.a("flame", f - f3, f1, f2 + f4, 0.0, 0.0, 0.0);
         } else if (i == 5) {
            par1World.a("smoke", f + f3, f1, f2 + f4, 0.0, 0.0, 0.0);
            par1World.a("flame", f + f3, f1, f2 + f4, 0.0, 0.0, 0.0);
         } else if (i == 2) {
            par1World.a("smoke", f + f4, f1, f2 - f3, 0.0, 0.0, 0.0);
            par1World.a("flame", f + f4, f1, f2 - f3, 0.0, 0.0, 0.0);
         } else if (i == 3) {
            par1World.a("smoke", f + f4, f1, f2 + f3, 0.0, 0.0, 0.0);
            par1World.a("flame", f + f4, f1, f2 + f3, 0.0, 0.0, 0.0);
         }
      }
   }

   @Override
   public int a_(int par1) {
      if (par1 == 1) {
         return this.bN + 17;
      } else if (par1 == 0) {
         return this.bN + 17;
      } else {
         return par1 == 3 ? this.bN - 1 : this.bN;
      }
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (par1World.F) {
         return true;
      }

      TileEntityFurnace tileentityfurnace = (TileEntityFurnace)par1World.getBlockTileEntity(par2, par3, par4);
      if (tileentityfurnace != null) {
         par5EntityPlayer.a(tileentityfurnace);
      }

      return true;
   }

   public static void updateFurnaceBlockState(boolean par0, World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
      c = true;
      if (par0) {
         par1World.setBlockWithNotify(par2, par3, par4, Block.aC.bO);
      } else {
         par1World.setBlockWithNotify(par2, par3, par4, Block.aB.bO);
      }

      c = false;
      par1World.setBlockMetadataWithNotify(par2, par3, par4, i);
      if (tileentity != null) {
         tileentity.m();
         par1World.setBlockTileEntity(par2, par3, par4, tileentity);
      }
   }

   @Override
   public TileEntity u_() {
      return new TileEntityFurnace();
   }

   @Override
   public void onBlockPlacedBy(World par1World, long par2, int par3, long par4, EntityLiving par5EntityLiving) {
      int i = MathHelper.c(par5EntityLiving.u * 4.0F / 360.0F + 0.5) & 3;
      if (i == 0) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 2);
      }

      if (i == 1) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 5);
      }

      if (i == 2) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
      }

      if (i == 3) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 4);
      }
   }

   @Override
   public void onBlockRemoval(World par1World, long par2, int par3, long par4) {
      if (!c) {
         TileEntityFurnace tileentityfurnace = (TileEntityFurnace)par1World.getBlockTileEntity(par2, par3, par4);
         if (tileentityfurnace != null) {
            for (int i = 0; i < tileentityfurnace.a(); i++) {
               ItemStack itemstack = tileentityfurnace.k_(i);
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
                     if (itemstack.n()) {
                        entityitem.a.d((ady)itemstack.o().b());
                     }

                     float f3 = 0.05F;
                     entityitem.r = (float)this.a.nextGaussian() * f3;
                     entityitem.s = (float)this.a.nextGaussian() * f3 + 0.2F;
                     entityitem.t = (float)this.a.nextGaussian() * f3;
                     par1World.a(entityitem);
                  }
               }
            }
         }
      }

      super.onBlockRemoval(par1World, par2, par3, par4);
   }
}
