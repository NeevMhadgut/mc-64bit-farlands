import java.util.Random;

public class BlockDispenser extends BlockContainer {
   private Random a = new Random();

   protected BlockDispenser(int par1) {
      super(par1, acn.e);
      this.bN = 45;
   }

   @Override
   public int e() {
      return 4;
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Block.P.bO;
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      super.onBlockAdded(par1World, par2, par3, par4);
      this.setDispenserDefaultDirection(par1World, par2, par3, par4);
   }

   private void setDispenserDefaultDirection(World par1World, long par2, int par3, long par4) {
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
      }

      if (par5 == 0) {
         return this.bN + 17;
      }

      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
      return par5 != i ? this.bN : this.bN + 1;
   }

   @Override
   public int a_(int par1) {
      if (par1 == 1) {
         return this.bN + 17;
      } else if (par1 == 0) {
         return this.bN + 17;
      } else {
         return par1 == 3 ? this.bN + 1 : this.bN;
      }
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (par1World.F) {
         return true;
      }

      TileEntityDispenser tileentitydispenser = (TileEntityDispenser)par1World.getBlockTileEntity(par2, par3, par4);
      if (tileentitydispenser != null) {
         par5EntityPlayer.a(tileentitydispenser);
      }

      return true;
   }

   private void dispenseItem(World par1World, long par2, int par3, long par4, Random par5Random) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      int j = 0;
      int k = 0;
      if (i == 3) {
         k = 1;
      } else if (i == 2) {
         k = -1;
      } else if (i == 5) {
         j = 1;
      } else {
         j = -1;
      }

      TileEntityDispenser tileentitydispenser = (TileEntityDispenser)par1World.getBlockTileEntity(par2, par3, par4);
      if (tileentitydispenser != null) {
         ItemStack itemstack = tileentitydispenser.m_();
         double d = par2 + j * 0.6 + 0.5;
         double d1 = par3 + 0.5;
         double d2 = par4 + k * 0.6 + 0.5;
         if (itemstack == null) {
            par1World.playAuxSFX(1001, par2, par3, par4, 0);
         } else {
            if (itemstack.c == Item.l.bQ) {
               EntityArrow entityarrow = new EntityArrow(par1World, d, d1, d2);
               entityarrow.a(j, 0.1F, k, 1.1F, 6.0F);
               entityarrow.a = true;
               par1World.a(entityarrow);
               par1World.playAuxSFX(1002, par2, par3, par4, 0);
            } else if (itemstack.c == Item.aP.bQ) {
               qe entityegg = new qe(par1World, d, d1, d2);
               entityegg.a(j, 0.1F, k, 1.1F, 6.0F);
               par1World.a(entityegg);
               par1World.playAuxSFX(1002, par2, par3, par4, 0);
            } else if (itemstack.c == Item.aD.bQ) {
               uq entitysnowball = new uq(par1World, d, d1, d2);
               entitysnowball.a(j, 0.1F, k, 1.1F, 6.0F);
               par1World.a(entitysnowball);
               par1World.playAuxSFX(1002, par2, par3, par4, 0);
            } else if (itemstack.c == Item.bs.bQ && ei.c(itemstack.i())) {
               EntityPotion entitypotion = new EntityPotion(par1World, d, d1, d2, itemstack.i());
               entitypotion.a(j, 0.1F, k, 1.375F, 3.0F);
               par1World.a(entitypotion);
               par1World.playAuxSFX(1002, par2, par3, par4, 0);
            } else if (itemstack.c == Item.bD.bQ) {
               EntityExpBottle entityexpbottle = new EntityExpBottle(par1World, d, d1, d2);
               entityexpbottle.a(j, 0.1F, k, 1.375F, 3.0F);
               par1World.a(entityexpbottle);
               par1World.playAuxSFX(1002, par2, par3, par4, 0);
            } else if (itemstack.c == Item.bC.bQ) {
               ItemMonsterPlacer.a(par1World, itemstack.i(), d + j * 0.3, d1 - 0.3, d2 + k * 0.3);
               par1World.playAuxSFX(1002, par2, par3, par4, 0);
            } else if (itemstack.c == Item.bE.bQ) {
               EntitySmallFireball entitysmallfireball = new EntitySmallFireball(
                  par1World,
                  d + j * 0.3,
                  d1,
                  d2 + k * 0.3,
                  j + par5Random.nextGaussian() * 0.05,
                  par5Random.nextGaussian() * 0.05,
                  k + par5Random.nextGaussian() * 0.05
               );
               par1World.a(entitysmallfireball);
               par1World.playAuxSFX(1009, par2, par3, par4, 0);
            } else {
               EntityItem entityitem = new EntityItem(par1World, d, d1 - 0.3, d2, itemstack);
               double d3 = par5Random.nextDouble() * 0.1 + 0.2;
               entityitem.r = j * d3;
               entityitem.s = 0.2F;
               entityitem.t = k * d3;
               entityitem.r = entityitem.r + par5Random.nextGaussian() * 0.0075F * 6.0;
               entityitem.s = entityitem.s + par5Random.nextGaussian() * 0.0075F * 6.0;
               entityitem.t = entityitem.t + par5Random.nextGaussian() * 0.0075F * 6.0;
               par1World.a(entityitem);
               par1World.playAuxSFX(1000, par2, par3, par4, 0);
            }

            par1World.playAuxSFX(2000, par2, par3, par4, j + 1 + (k + 1) * 3);
         }
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (par5 > 0 && Block.m[par5].g()) {
         boolean flag = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4) || par1World.isBlockIndirectlyGettingPowered(par2, par3 + 1, par4);
         if (flag) {
            par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, this.e());
         }
      }
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (!par1World.F && (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4) || par1World.isBlockIndirectlyGettingPowered(par2, par3 + 1, par4))) {
         this.dispenseItem(par1World, par2, par3, par4, par5Random);
      }
   }

   @Override
   public TileEntity u_() {
      return new TileEntityDispenser();
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
      TileEntityDispenser tileentitydispenser = (TileEntityDispenser)par1World.getBlockTileEntity(par2, par3, par4);
      if (tileentitydispenser != null) {
         for (int i = 0; i < tileentitydispenser.a(); i++) {
            ItemStack itemstack = tileentitydispenser.k_(i);
            if (itemstack != null) {
               double f = this.a.nextFloat() * 0.8 + 0.1;
               double f1 = this.a.nextFloat() * 0.8 + 0.1;
               double f2 = this.a.nextFloat() * 0.8 + 0.1;

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

      super.onBlockRemoval(par1World, par2, par3, par4);
   }
}
