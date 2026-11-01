import java.util.ArrayList;

public class BlockPistonBase extends Block {
   private boolean a;
   private static boolean b;

   public BlockPistonBase(int par1, int par2, boolean par3) {
      super(par1, par2, acn.E);
      this.a = par3;
      this.a(h);
      this.c(0.5F);
   }

   public int v() {
      return !this.a ? 107 : 106;
   }

   @Override
   public int a(int par1, int par2) {
      int i = e(par2);
      if (i > 5) {
         return this.bN;
      } else if (par1 == i) {
         return !h(par2) && !(this.bV > 0.0) && !(this.bW > 0.0) && !(this.bX > 0.0) && !(this.bY < 1.0) && !(this.bZ < 1.0) && !(this.IChunkProvider < 1.0)
            ? this.bN
            : 110;
      } else {
         return par1 != qs.a[i] ? 108 : 109;
      }
   }

   @Override
   public int d() {
      return 16;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long i, EntityPlayer entityplayer) {
      return false;
   }

   @Override
   public void onBlockPlacedBy(World par1World, long par2, int par3, long par4, EntityLiving par5EntityLiving) {
      int i = determineOrientation(par1World, par2, par3, par4, (EntityPlayer)par5EntityLiving);
      par1World.setBlockMetadataWithNotify(par2, par3, par4, i);
      if (!par1World.F && !b) {
         this.updatePistonState(par1World, par2, par3, par4);
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (!par1World.F && !b) {
         this.updatePistonState(par1World, par2, par3, par4);
      }
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      if (!par1World.F && par1World.getBlockTileEntity(par2, par3, par4) == null && !b) {
         this.updatePistonState(par1World, par2, par3, par4);
      }
   }

   private void updatePistonState(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      int j = e(i);
      boolean flag = this.isIndirectlyPowered(par1World, par2, par3, par4, j);
      if (i != 7) {
         if (flag && !h(i)) {
            if (canExtend(par1World, par2, par3, par4, j)) {
               par1World.setBlockMetadata(par2, par3, par4, j | 8);
               par1World.playNoteAt(par2, par3, par4, 0, j);
            }
         } else if (!flag && h(i)) {
            par1World.setBlockMetadata(par2, par3, par4, j);
            par1World.playNoteAt(par2, par3, par4, 1, j);
         }
      }
   }

   private boolean isIndirectlyPowered(World par1World, long par2, int par3, long par4, int par5) {
      if (par5 != 0 && par1World.isBlockIndirectlyProvidingPowerTo(par2, par3 - 1, par4, 0)) {
         return true;
      } else if (par5 != 1 && par1World.isBlockIndirectlyProvidingPowerTo(par2, par3 + 1, par4, 1)) {
         return true;
      } else if (par5 != 2 && par1World.isBlockIndirectlyProvidingPowerTo(par2, par3, par4 - 1L, 2)) {
         return true;
      } else if (par5 != 3 && par1World.isBlockIndirectlyProvidingPowerTo(par2, par3, par4 + 1L, 3)) {
         return true;
      } else if (par5 != 5 && par1World.isBlockIndirectlyProvidingPowerTo(par2 + 1L, par3, par4, 5)) {
         return true;
      } else if (par5 != 4 && par1World.isBlockIndirectlyProvidingPowerTo(par2 - 1L, par3, par4, 4)) {
         return true;
      } else if (par1World.isBlockIndirectlyProvidingPowerTo(par2, par3, par4, 0)) {
         return true;
      } else if (par1World.isBlockIndirectlyProvidingPowerTo(par2, par3 + 2, par4, 1)) {
         return true;
      } else if (par1World.isBlockIndirectlyProvidingPowerTo(par2, par3 + 1, par4 - 1L, 2)) {
         return true;
      } else if (par1World.isBlockIndirectlyProvidingPowerTo(par2, par3 + 1, par4 + 1L, 3)) {
         return true;
      } else {
         return par1World.isBlockIndirectlyProvidingPowerTo(par2 - 1L, par3 + 1, par4, 4)
            ? true
            : par1World.isBlockIndirectlyProvidingPowerTo(par2 + 1L, par3 + 1, par4, 5);
      }
   }

   @Override
   public void powerBlock(World par1World, long par2, int par3, long par4, int par5, int par6) {
      b = true;
      int i = par6;
      if (par5 == 0) {
         if (this.tryExtend(par1World, par2, par3, par4, i)) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, i | 8);
            par1World.a(par2 + 0.5, par3 + 0.5, par4 + 0.5, "tile.piston.out", 0.5F, par1World.r.nextFloat() * 0.25F + 0.6F);
         } else {
            par1World.setBlockMetadata(par2, par3, par4, i);
         }
      } else if (par5 == 1) {
         TileEntity tileentity = par1World.getBlockTileEntity(par2 + qs.b[i], par3 + qs.c[i], par4 + qs.d[i]);
         if (tileentity != null && tileentity instanceof TileEntityPiston) {
            ((TileEntityPiston)tileentity).g();
         }

         par1World.setBlockAndMetadata(par2, par3, par4, Block.EntityNoteFX.bO, i);
         par1World.setBlockTileEntity(par2, par3, par4, BlockPistonMoving.a(this.bO, i, i, false, true));
         if (this.a) {
            long j = par2 + qs.b[i] * 2;
            int k = par3 + qs.c[i] * 2;
            long l = par4 + qs.d[i] * 2;
            int i1 = par1World.getBlockId(j, k, l);
            int j1 = par1World.getBlockMetadata(j, k, l);
            boolean flag = false;
            if (i1 == Block.EntityNoteFX.bO) {
               TileEntity tileentity1 = par1World.getBlockTileEntity(j, k, l);
               if (tileentity1 != null && tileentity1 instanceof TileEntityPiston) {
                  TileEntityPiston tileentitypiston = (TileEntityPiston)tileentity1;
                  if (tileentitypiston.e() == i && tileentitypiston.d()) {
                     tileentitypiston.g();
                     i1 = tileentitypiston.a();
                     j1 = tileentitypiston.i();
                     flag = true;
                  }
               }
            }

            if (flag || i1 <= 0 || !canPushBlock(i1, par1World, j, k, l, false) || Block.m[i1].f() != 0 && i1 != Block.Z.bO && i1 != Block.V.bO) {
               if (!flag) {
                  b = false;
                  par1World.setBlockWithNotify(par2 + qs.b[i], par3 + qs.c[i], par4 + qs.d[i], 0);
                  b = true;
               }
            } else {
               par2 += qs.b[i];
               par3 += qs.c[i];
               par4 += qs.d[i];
               par1World.setBlockAndMetadata(par2, par3, par4, Block.EntityNoteFX.bO, j1);
               par1World.setBlockTileEntity(par2, par3, par4, BlockPistonMoving.a(i1, j1, i, false, false));
               b = false;
               par1World.setBlockWithNotify(j, k, l, 0);
               b = true;
            }
         } else {
            b = false;
            par1World.setBlockWithNotify(par2 + qs.b[i], par3 + qs.c[i], par4 + qs.d[i], 0);
            b = true;
         }

         par1World.a(par2 + 0.5, par3 + 0.5, par4 + 0.5, "tile.piston.in", 0.5F, par1World.r.nextFloat() * 0.15F + 0.6F);
      }

      b = false;
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
      if (h(i)) {
         switch (e(i)) {
            case 0:
               this.a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
               break;
            case 1:
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
               break;
            case 2:
               this.a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
               break;
            case 3:
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
               break;
            case 4:
               this.a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
               break;
            case 5:
               this.a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
         }
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   @Override
   public void h() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   @Override
   public void getCollidingBoundingBoxes(World par1World, long par2, int par3, long par4, AxisAlignedBB par5AxisAlignedBB, ArrayList par6ArrayList) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
      return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
   }

   @Override
   public boolean b() {
      return false;
   }

   public static int e(int par0) {
      return par0 & 7;
   }

   public static boolean h(int par0) {
      return (par0 & 8) != 0;
   }

   private static int determineOrientation(World par0World, long par1, int par2, long par3, EntityPlayer par4EntityPlayer) {
      if (MathHelper.e((float)par4EntityPlayer.o - (float)par1) < 2.0F && MathHelper.e((float)par4EntityPlayer.q - (float)par3) < 2.0F) {
         double d = par4EntityPlayer.p + 1.82 - par4EntityPlayer.H;
         if (d - par2 > 2.0) {
            return 1;
         }

         if (par2 - d > 0.0) {
            return 0;
         }
      }

      int i = MathHelper.c(par4EntityPlayer.u * 4.0F / 360.0F + 0.5) & 3;
      if (i == 0) {
         return 2;
      } else if (i == 1) {
         return 5;
      } else if (i == 2) {
         return 3;
      } else {
         return i != 3 ? 0 : 4;
      }
   }

   private static boolean canPushBlock(int par0, World par1World, long par2, int par3, long par4, boolean par5) {
      if (par0 == Block.ap.bO) {
         return false;
      }

      if (par0 != Block.Z.bO && par0 != Block.V.bO) {
         if (Block.m[par0].n() == -1.0F) {
            return false;
         }

         if (Block.m[par0].f() == 2) {
            return false;
         }

         if (!par5 && Block.m[par0].f() == 1) {
            return false;
         }
      } else if (h(par1World.getBlockMetadata(par2, par3, par4))) {
         return false;
      }

      return !(Block.m[par0] instanceof BlockContainer);
   }

   private static boolean canExtend(World par0World, long par1, int par2, long par3, int par4) {
      long i = par1 + qs.b[par4];
      int j = par2 + qs.c[par4];
      long k = par3 + qs.d[par4];

      for (int l = 0; l < 13; l++) {
         if (j <= 0 || j >= 255) {
            return false;
         }

         int i1 = par0World.getBlockId(i, j, k);
         if (i1 != 0) {
            if (!canPushBlock(i1, par0World, i, j, k, true)) {
               return false;
            }

            if (Block.m[i1].f() != 1) {
               if (l == 12) {
                  return false;
               }

               i += qs.b[par4];
               j += qs.c[par4];
               k += qs.d[par4];
               continue;
            }
         }
         break;
      }

      return true;
   }

   private boolean tryExtend(World par1World, long par2, int par3, long par4, int par5) {
      long i = par2 + qs.b[par5];
      int j = par3 + qs.c[par5];
      long k = par4 + qs.d[par5];
      int l = 0;

      while (l < 13) {
         if (j <= 0 || j >= 255) {
            return false;
         }

         int j1 = par1World.getBlockId(i, j, k);
         if (j1 == 0) {
            break;
         }

         if (!canPushBlock(j1, par1World, i, j, k, true)) {
            return false;
         }

         if (Block.m[j1].f() != 1) {
            if (l == 12) {
               return false;
            }

            i += qs.b[par5];
            j += qs.c[par5];
            k += qs.d[par5];
            l++;
         } else {
            Block.m[j1].dropBlockAsItem(par1World, i, j, k, par1World.getBlockMetadata(i, j, k), 0);
            par1World.setBlockWithNotify(i, j, k, 0);
            break;
         }
      }

      while (i != par2 || j != par3 || k != par4) {
         long i1 = i - qs.b[par5];
         int k1 = j - qs.c[par5];
         long l1 = k - qs.d[par5];
         int i2 = par1World.getBlockId(i1, k1, l1);
         int j2 = par1World.getBlockMetadata(i1, k1, l1);
         if (i2 == this.bO && i1 == par2 && k1 == par3 && l1 == par4) {
            par1World.setBlockAndMetadata(i, j, k, Block.EntityNoteFX.bO, par5 | (this.a ? 8 : 0));
            par1World.setBlockTileEntity(i, j, k, BlockPistonMoving.a(Block.BlockSnowBlock.bO, par5 | (this.a ? 8 : 0), par5, true, false));
         } else {
            par1World.setBlockAndMetadata(i, j, k, Block.EntityNoteFX.bO, j2);
            par1World.setBlockTileEntity(i, j, k, BlockPistonMoving.a(i2, j2, par5, true, false));
         }

         i = i1;
         j = k1;
         k = l1;
      }

      return true;
   }
}
