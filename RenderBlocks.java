import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class RenderBlocks {
   public IBlockAccess a;
   private int d;
   private boolean e;
   private boolean f;
   public static boolean b = true;
   public boolean c;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private int l;
   private boolean m;
   private float n;
   private float o;
   private float p;
   private float q;
   private float r;
   private float s;
   private float t;
   private float u;
   private float v;
   private float w;
   private float x;
   private float y;
   private float z;
   private float A;
   private float B;
   private float C;
   private float D;
   private float E;
   private float F;
   private float G;
   private float H;
   private float I;
   private float J;
   private float K;
   private float L;
   private float M;
   private float N;
   private int O;
   private int P;
   private int Q;
   private int R;
   private int S;
   private int T;
   private int U;
   private int V;
   private int W;
   private int X;
   private int Y;
   private int Z;
   private int BlockSnowBlock;
   private int ab;
   private int EntityNoteFX;
   private int ad;
   private int BlockTNT;
   private int TileEntityMobSpawnerRenderer;
   private int ag;
   private int ah;
   private int ai;
   private int aj;
   private int ak;
   private int BlockPortal;
   private int NoiseGeneratorPerlin;
   private float MapGenVillage;
   private float GenLayerHills;
   private float ap;
   private float aq;
   private float ar;
   private float as;
   private float at;
   private float au;
   private float EntityThrowable;
   private float aw;
   private float EntityAIAttackOnCollide;
   private float StructureNetherBridgeStart;
   private boolean TileEntityDispenser;
   private boolean aA;
   private boolean aB;
   private boolean aC;
   private boolean aD;
   private boolean aE;
   private boolean aF;
   private boolean aG;
   private boolean aH;
   private boolean aI;
   private boolean aJ;
   private boolean aK;
   public boolean isHitbox = false;
   public static boolean stripeLandsFix = false;

   public RenderBlocks(IBlockAccess par1IBlockAccess) {
      this.d = -1;
      this.e = false;
      this.f = false;
      this.c = true;
      this.g = 0;
      this.h = 0;
      this.i = 0;
      this.j = 0;
      this.k = 0;
      this.l = 0;
      this.ai = 1;
      this.a = par1IBlockAccess;
   }

   public RenderBlocks() {
      this.d = -1;
      this.e = false;
      this.f = false;
      this.c = true;
      this.g = 0;
      this.h = 0;
      this.i = 0;
      this.j = 0;
      this.k = 0;
      this.l = 0;
      this.ai = 1;
   }

   public void a() {
      this.d = -1;
   }

   public void renderBlockUsingTexture(Block par1Block, long par2, int par3, long par4, int par5) {
      this.d = par5;
      this.renderBlockByRenderType(par1Block, par2, par3, par4);
      this.d = -1;
   }

   public void renderBlockAllFaces(Block par1Block, long par2, int par3, long par4) {
      this.f = true;
      this.renderBlockByRenderType(par1Block, par2, par3, par4);
      this.f = false;
   }

   public boolean renderBlockByRenderType(Block par1Block, long par2, int par3, long par4) {
      int i = par1Block.d();
      par1Block.setBlockBoundsBasedOnState(this.a, par2, par3, par4);
      if (i == 0) {
         return this.renderStandardBlock(par1Block, par2, par3, par4);
      } else if (i == 4) {
         return this.renderBlockFluids(par1Block, par2, par3, par4);
      } else if (i == 13) {
         return this.renderBlockCactus(par1Block, par2, par3, par4);
      } else if (i == 1) {
         return this.renderCrossedSquares(par1Block, par2, par3, par4);
      } else if (i == 19) {
         return this.renderBlockStem(par1Block, par2, par3, par4);
      } else if (i == 23) {
         return this.renderBlockLilyPad(par1Block, par2, par3, par4);
      } else if (i == 6) {
         return this.renderBlockCrops(par1Block, par2, par3, par4);
      } else if (i == 2) {
         return this.renderBlockTorch(par1Block, par2, par3, par4);
      } else if (i == 3) {
         return this.renderBlockFire(par1Block, par2, par3, par4);
      } else if (i == 5) {
         return this.renderBlockRedstoneWire(par1Block, par2, par3, par4);
      } else if (i == 8) {
         return this.renderBlockLadder(par1Block, par2, par3, par4);
      } else if (i == 7) {
         return this.renderBlockDoor(par1Block, par2, par3, par4);
      } else if (i == 9) {
         return this.renderBlockMinecartTrack((BlockRail)par1Block, par2, par3, par4);
      } else if (i == 10) {
         return this.renderBlockStairs(par1Block, par2, par3, par4);
      } else if (i == 27) {
         return this.renderBlockDragonEgg((BlockDragonEgg)par1Block, par2, par3, par4);
      } else if (i == 11) {
         return this.renderBlockFence((BlockFence)par1Block, par2, par3, par4);
      } else if (i == 12) {
         return this.renderBlockLever(par1Block, par2, par3, par4);
      } else if (i == 14) {
         return this.renderBlockBed(par1Block, par2, par3, par4);
      } else if (i == 15) {
         return this.renderBlockRepeater(par1Block, par2, par3, par4);
      } else if (i == 16) {
         return this.renderPistonBase(par1Block, par2, par3, par4, false);
      } else if (i == 17) {
         return this.renderPistonExtension(par1Block, par2, par3, par4, true);
      } else if (i == 18) {
         return this.renderBlockPane((BlockPane)par1Block, par2, par3, par4);
      } else if (i == 20) {
         return this.renderBlockVine(par1Block, par2, par3, par4);
      } else if (i == 21) {
         return this.renderBlockFenceGate((BlockFenceGate)par1Block, par2, par3, par4);
      } else if (i == 24) {
         return this.renderBlockCauldron((BlockCauldron)par1Block, par2, par3, par4);
      } else if (i == 25) {
         return this.renderBlockBrewingStand((BlockBrewingStand)par1Block, par2, par3, par4);
      } else {
         return i == 26 ? this.renderBlockEndPortalFrame(par1Block, par2, par3, par4) : false;
      }
   }

   private boolean renderBlockEndPortalFrame(Block par1Block, long par2, int par3, long par4) {
      int i = this.a.getBlockMetadata(par2, par3, par4);
      int j = i & 3;
      if (j == 0) {
         this.k = 3;
      } else if (j == 3) {
         this.k = 1;
      } else if (j == 1) {
         this.k = 2;
      }

      if (!BlockEndPortalFrame.e(i)) {
         par1Block.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
         this.renderStandardBlock(par1Block, par2, par3, par4);
         par1Block.h();
         this.k = 0;
         return true;
      } else {
         par1Block.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
         this.renderStandardBlock(par1Block, par2, par3, par4);
         this.d = 174;
         par1Block.a(0.25F, 0.8125F, 0.25F, 0.75F, 1.0F, 0.75F);
         this.renderStandardBlock(par1Block, par2, par3, par4);
         this.a();
         par1Block.h();
         this.k = 0;
         return true;
      }
   }

   private boolean renderBlockBed(Block par1Block, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      Tessellator tessellator = Tessellator.a;
      int i = this.a.getBlockMetadata(par2, par3, par4);
      int j = BlockBed.a(i);
      boolean flag = BlockBed.e(i);
      float f = 0.5F;
      float f1 = 1.0F;
      float f2 = 0.8F;
      float f3 = 0.6F;
      float f4 = f1;
      float f5 = f1;
      float f6 = f1;
      float f7 = f;
      float f8 = f2;
      float f9 = f3;
      float f10 = f;
      float f11 = f2;
      float f12 = f3;
      float f13 = f;
      float f14 = f2;
      float f15 = f3;
      int k = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4);
      tessellator.b(k);
      tessellator.a(f7, f10, f13);
      int l = par1Block.getBlockTexture(this.a, par2, par3, par4, 0);
      int i1 = (l & 15) << 4;
      int j1 = l & 240;
      double d = i1 / 256.0F;
      double d1 = (i1 + 16 - 0.01) / 256.0;
      double d2 = j1 / 256.0F;
      double d3 = (j1 + 16 - 0.01) / 256.0;
      double d4 = par2 + par1Block.bV;
      double d5 = par2 + par1Block.bY;
      double d6 = par3 + par1Block.bW + 0.1875;
      double d7 = par4 + par1Block.bX;
      double d8 = par4 + par1Block.IChunkProvider;
      if (useFix) {
         d4 = par2a + par1Block.bV;
         d5 = par2a + par1Block.bY;
         d6 = par3a + par1Block.bW + 0.1875;
         d7 = par4a + par1Block.bX;
         d8 = par4a + par1Block.IChunkProvider;
         tessellator.addVertexWithUVNoOffset(d4, d6, d8, d, d3);
         tessellator.addVertexWithUVNoOffset(d4, d6, d7, d, d2);
         tessellator.addVertexWithUVNoOffset(d5, d6, d7, d1, d2);
         tessellator.addVertexWithUVNoOffset(d5, d6, d8, d1, d3);
      } else {
         tessellator.a(d4, d6, d8, d, d3);
         tessellator.a(d4, d6, d7, d, d2);
         tessellator.a(d5, d6, d7, d1, d2);
         tessellator.a(d5, d6, d8, d1, d3);
      }

      tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, par2, par3 + 1, par4));
      tessellator.a(f4, f5, f6);
      l = par1Block.getBlockTexture(this.a, par2, par3, par4, 1);
      i1 = (l & 15) << 4;
      j1 = l & 240;
      d = i1 / 256.0F;
      d1 = (i1 + 16 - 0.01) / 256.0;
      d2 = j1 / 256.0F;
      d3 = (j1 + 16 - 0.01) / 256.0;
      d4 = d;
      d5 = d1;
      d6 = d2;
      d7 = d2;
      d8 = d;
      double d9 = d1;
      double d10 = d3;
      double d11 = d3;
      if (j == 0) {
         d5 = d;
         d6 = d3;
         d8 = d1;
         d11 = d2;
      } else if (j == 2) {
         d4 = d1;
         d7 = d3;
         d9 = d;
         d10 = d2;
      } else if (j == 3) {
         d4 = d1;
         d7 = d3;
         d9 = d;
         d10 = d2;
         d5 = d;
         d6 = d3;
         d8 = d1;
         d11 = d2;
      }

      double d12 = par2 + par1Block.bV;
      double d13 = par2 + par1Block.bY;
      double d14 = par3 + par1Block.bZ;
      double d15 = par4 + par1Block.bX;
      double d16 = par4 + par1Block.IChunkProvider;
      if (useFix) {
         d12 = par2a + par1Block.bV;
         d13 = par2a + par1Block.bY;
         d14 = par3a + par1Block.bZ;
         d15 = par4a + par1Block.bX;
         d16 = par4a + par1Block.IChunkProvider;
         tessellator.addVertexWithUVNoOffset(d13, d14, d16, d8, d10);
         tessellator.addVertexWithUVNoOffset(d13, d14, d15, d4, d6);
         tessellator.addVertexWithUVNoOffset(d12, d14, d15, d5, d7);
         tessellator.addVertexWithUVNoOffset(d12, d14, d16, d9, d11);
      } else {
         tessellator.a(d13, d14, d16, d8, d10);
         tessellator.a(d13, d14, d15, d4, d6);
         tessellator.a(d12, d14, d15, d5, d7);
         tessellator.a(d12, d14, d16, d9, d11);
      }

      l = aav.c[j];
      if (flag) {
         l = aav.c[aav.e[j]];
      }

      int var74 = 4;
      switch (j) {
         case 0:
            var74 = 5;
            break;
         case 1:
            var74 = 3;
         case 2:
         default:
            break;
         case 3:
            var74 = 2;
      }

      if (l != 2 && (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3, par4 - 1L, 2))) {
         tessellator.b(par1Block.bX <= 0.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 - 1L) : k);
         tessellator.a(f8, f11, f14);
         this.e = var74 == 2;
         if (useFix) {
            this.renderEastFace(par1Block, par2a, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 2), true);
         } else {
            this.c(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 2));
         }
      }

      if (l != 3 && (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3, par4 + 1L, 3))) {
         tessellator.b(par1Block.IChunkProvider >= 1.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 + 1L) : k);
         tessellator.a(f8, f11, f14);
         this.e = var74 == 3;
         if (useFix) {
            this.renderWestFace(par1Block, par2a, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 3), true);
         } else {
            this.d(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 3));
         }
      }

      if (l != 4 && (this.f || par1Block.shouldSideBeRendered(this.a, par2 - 1L, par3, par4, 4))) {
         tessellator.b(par1Block.bX <= 0.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3, par4) : k);
         tessellator.a(f9, f12, f15);
         this.e = var74 == 4;
         if (useFix) {
            this.renderNorthFace(par1Block, par2a, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 4), true);
         } else {
            this.e(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 4));
         }
      }

      if (l != 5 && (this.f || par1Block.shouldSideBeRendered(this.a, par2 + 1L, par3, par4, 5))) {
         tessellator.b(par1Block.IChunkProvider >= 1.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3, par4) : k);
         tessellator.a(f9, f12, f15);
         this.e = var74 == 5;
         if (useFix) {
            this.renderSouthFace(par1Block, par2a, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 5), true);
         } else {
            this.f(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 5));
         }
      }

      this.e = false;
      return true;
   }

   private boolean renderBlockBrewingStand(BlockBrewingStand par1BlockBrewingStand, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      par1BlockBrewingStand.a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
      this.renderStandardBlock(par1BlockBrewingStand, par2, par3, par4);
      this.d = 156;
      par1BlockBrewingStand.a(0.5625F, 0.0F, 0.3125F, 0.9375F, 0.125F, 0.6875F);
      this.renderStandardBlock(par1BlockBrewingStand, par2, par3, par4);
      par1BlockBrewingStand.a(0.125F, 0.0F, 0.0625F, 0.5F, 0.125F, 0.4375F);
      this.renderStandardBlock(par1BlockBrewingStand, par2, par3, par4);
      par1BlockBrewingStand.a(0.125F, 0.0F, 0.5625F, 0.5F, 0.125F, 0.9375F);
      this.renderStandardBlock(par1BlockBrewingStand, par2, par3, par4);
      this.a();
      Tessellator tessellator = Tessellator.a;
      tessellator.b(par1BlockBrewingStand.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      float f = 1.0F;
      int i = par1BlockBrewingStand.colorMultiplier(this.a, par2, par3, par4);
      float f1 = (i >> 16 & 0xFF) / 255.0F;
      float f2 = (i >> 8 & 0xFF) / 255.0F;
      float f3 = (i & 0xFF) / 255.0F;
      if (EntityRenderer.a) {
         float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
         float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
         float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
         f1 = f4;
         f2 = f5;
         f3 = f6;
      }

      tessellator.a(f * f1, f * f2, f * f3);
      int j = par1BlockBrewingStand.a(0, 0);
      if (this.d >= 0) {
         j = this.d;
      }

      int k = (j & 15) << 4;
      int l = j & 240;
      double d = l / 256.0F;
      double d1 = (l + 15.99F) / 256.0F;
      int i1 = this.a.getBlockMetadata(par2, par3, par4);

      for (int j1 = 0; j1 < 3; j1++) {
         double d2 = j1 * Math.PI * 2.0 / 3.0 + (Math.PI / 2);
         double d3 = (k + 8.0F) / 256.0F;
         double d4 = (k + 15.99F) / 256.0F;
         if ((i1 & 1 << j1) != 0) {
            d3 = (k + 7.99F) / 256.0F;
            d4 = (k + 0.0F) / 256.0F;
         }

         double d5 = par2 + 0.5;
         double d6 = par2 + 0.5 + Math.sin(d2) * 8.0 / 16.0;
         double d7 = par4 + 0.5;
         double d8 = par4 + 0.5 + Math.cos(d2) * 8.0 / 16.0;
         if (useFix) {
            d5 = par2a + 0.5;
            d6 = par2a + 0.5 + Math.sin(d2) * 8.0 / 16.0;
            d7 = par4a + 0.5;
            d8 = par4a + 0.5 + Math.cos(d2) * 8.0 / 16.0;
            tessellator.addVertexWithUVNoOffset(d5, par3a + 1, d7, d3, d);
            tessellator.addVertexWithUVNoOffset(d5, par3a + 0, d7, d3, d1);
            tessellator.addVertexWithUVNoOffset(d6, par3a + 0, d8, d4, d1);
            tessellator.addVertexWithUVNoOffset(d6, par3a + 1, d8, d4, d);
            tessellator.addVertexWithUVNoOffset(d6, par3a + 1, d8, d4, d);
            tessellator.addVertexWithUVNoOffset(d6, par3a + 0, d8, d4, d1);
            tessellator.addVertexWithUVNoOffset(d5, par3a + 0, d7, d3, d1);
            tessellator.addVertexWithUVNoOffset(d5, par3a + 1, d7, d3, d);
         } else {
            tessellator.a(d5, par3 + 1, d7, d3, d);
            tessellator.a(d5, par3 + 0, d7, d3, d1);
            tessellator.a(d6, par3 + 0, d8, d4, d1);
            tessellator.a(d6, par3 + 1, d8, d4, d);
            tessellator.a(d6, par3 + 1, d8, d4, d);
            tessellator.a(d6, par3 + 0, d8, d4, d1);
            tessellator.a(d5, par3 + 0, d7, d3, d1);
            tessellator.a(d5, par3 + 1, d7, d3, d);
         }
      }

      par1BlockBrewingStand.h();
      return true;
   }

   private boolean renderBlockCauldron(BlockCauldron par1BlockCauldron, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      this.renderStandardBlock(par1BlockCauldron, par2, par3, par4);
      Tessellator tessellator = Tessellator.a;
      tessellator.b(par1BlockCauldron.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      float f = 1.0F;
      int i = par1BlockCauldron.colorMultiplier(this.a, par2, par3, par4);
      float f1 = (i >> 16 & 0xFF) / 255.0F;
      float f2 = (i >> 8 & 0xFF) / 255.0F;
      float f3 = (i & 0xFF) / 255.0F;
      if (EntityRenderer.a) {
         float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
         float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
         float f7 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
         f1 = f4;
         f2 = f5;
         f3 = f7;
      }

      tessellator.a(f * f1, f * f2, f * f3);
      char c = 154;
      char c1 = 139;
      double f6 = 0.875;
      if (useFix) {
         this.renderSouthFace(par1BlockCauldron, par2a - f6, par3a, par4a, c, true);
         this.renderNorthFace(par1BlockCauldron, par2a + f6, par3a, par4a, c, true);
         this.renderWestFace(par1BlockCauldron, par2a, par3a, par4a - f6, c, true);
         this.renderEastFace(par1BlockCauldron, par2a, par3a, par4a + f6, c, true);
         this.renderTopFace(par1BlockCauldron, par2a, par3a - 0.75, par4a, c1, true);
         this.renderBottomFace(par1BlockCauldron, par2a, par3a + 0.25, par4a, c1, true);
      } else {
         this.f(par1BlockCauldron, par2 - f6, par3, par4, c);
         this.e(par1BlockCauldron, par2 + f6, par3, par4, c);
         this.d(par1BlockCauldron, par2, par3, par4 - f6, c);
         this.c(par1BlockCauldron, par2, par3, par4 + f6, c);
         this.b(par1BlockCauldron, par2, par3 - 0.75, par4, c1);
         this.a(par1BlockCauldron, par2, par3 + 0.25, par4, c1);
      }

      int j = this.a.getBlockMetadata(par2, par3, par4);
      if (j > 0) {
         char c2 = 205;
         if (j > 3) {
            j = 3;
         }

         if (useFix) {
            this.renderTopFace(par1BlockCauldron, par2a, (double)(par3a - 1) + (6.0F + j * 3.0F) / 16.0F, par4a, c2, true);
         } else {
            this.b(par1BlockCauldron, par2, (double)(par3 - 1) + (6.0F + j * 3.0F) / 16.0F, par4, c2);
         }
      }

      return true;
   }

   public boolean renderBlockTorch(Block par1Block, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      int i = this.a.getBlockMetadata(par2, par3, par4);
      Tessellator tessellator = Tessellator.a;
      tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      tessellator.a(1.0F, 1.0F, 1.0F);
      double d = 0.4F;
      double d1 = 0.5 - d;
      double d2 = 0.2F;
      if (useFix) {
         if (i == 1) {
            this.renderTorchAtAngleNoOffset(par1Block, par2a - d1, par3a + d2, par4a, -d, 0.0);
         } else if (i == 2) {
            this.renderTorchAtAngleNoOffset(par1Block, par2a + d1, par3a + d2, par4a, d, 0.0);
         } else if (i == 3) {
            this.renderTorchAtAngleNoOffset(par1Block, par2a, par3a + d2, par4a - d1, 0.0, -d);
         } else if (i == 4) {
            this.renderTorchAtAngleNoOffset(par1Block, par2a, par3a + d2, par4a + d1, 0.0, d);
         } else {
            this.renderTorchAtAngleNoOffset(par1Block, par2a, par3a, par4a, 0.0, 0.0);
         }
      } else if (i == 1) {
         this.a(par1Block, par2 - d1, par3 + d2, par4, -d, 0.0);
      } else if (i == 2) {
         this.a(par1Block, par2 + d1, par3 + d2, par4, d, 0.0);
      } else if (i == 3) {
         this.a(par1Block, par2, par3 + d2, par4 - d1, 0.0, -d);
      } else if (i == 4) {
         this.a(par1Block, par2, par3 + d2, par4 + d1, 0.0, d);
      } else {
         this.a(par1Block, par2, par3, par4, 0.0, 0.0);
      }

      return true;
   }

   private boolean renderBlockRepeater(Block par1Block, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      int i = this.a.getBlockMetadata(par2, par3, par4);
      int j = i & 3;
      int k = (i & 12) >> 2;
      this.renderStandardBlock(par1Block, par2, par3, par4);
      Tessellator tessellator = Tessellator.a;
      tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      tessellator.a(1.0F, 1.0F, 1.0F);
      double d = -0.1875;
      double d1 = 0.0;
      double d2 = 0.0;
      double d3 = 0.0;
      double d4 = 0.0;
      switch (j) {
         case 0:
            d4 = -0.3125;
            d2 = BlockRedstoneRepeater.a[k];
            break;
         case 1:
            d3 = 0.3125;
            d1 = -BlockRedstoneRepeater.a[k];
            break;
         case 2:
            d4 = 0.3125;
            d2 = -BlockRedstoneRepeater.a[k];
            break;
         case 3:
            d3 = -0.3125;
            d1 = BlockRedstoneRepeater.a[k];
      }

      if (useFix) {
         this.renderTorchAtAngleNoOffset(par1Block, par2a + d1, par3a + d, par4a + d2, 0.0, 0.0);
         this.renderTorchAtAngleNoOffset(par1Block, par2a + d3, par3a + d, par4a + d4, 0.0, 0.0);
      } else {
         this.a(par1Block, par2 + d1, par3 + d, par4 + d2, 0.0, 0.0);
         this.a(par1Block, par2 + d3, par3 + d, par4 + d4, 0.0, 0.0);
      }

      int l = par1Block.a_(1);
      int i1 = (l & 15) << 4;
      int j1 = l & 240;
      double d5 = i1 / 256.0F;
      double d6 = (i1 + 15.99F) / 256.0F;
      double d7 = j1 / 256.0F;
      double d8 = (j1 + 15.99F) / 256.0F;
      double d9 = 0.125;
      long d10;
      long d11;
      long d12;
      long d13;
      long d14;
      long d15;
      long d16;
      long d17;
      double d18;
      if (useFix) {
         d10 = par2a + 1L;
         d11 = par2a + 1L;
         d12 = par2a + 0L;
         d13 = par2a + 0L;
         d14 = par4a + 0L;
         d15 = par4a + 1L;
         d16 = par4a + 1L;
         d17 = par4a + 0L;
         d18 = par3a + d9;
         if (j == 2) {
            d10 = d11 = par2a + 0L;
            d12 = d13 = par2a + 1L;
            d14 = d17 = par4a + 1L;
            d15 = d16 = par4a + 0L;
         } else if (j == 3) {
            d10 = d13 = par2a + 0L;
            d11 = d12 = par2a + 1L;
            d14 = d15 = par4a + 0L;
            d16 = d17 = par4a + 1L;
         } else if (j == 1) {
            d10 = d13 = par2a + 1L;
            d11 = d12 = par2a + 0L;
            d14 = d15 = par4a + 1L;
            d16 = d17 = par4a + 0L;
         }
      } else {
         d10 = par2 + 1L;
         d11 = par2 + 1L;
         d12 = par2 + 0L;
         d13 = par2 + 0L;
         d14 = par4 + 0L;
         d15 = par4 + 1L;
         d16 = par4 + 1L;
         d17 = par4 + 0L;
         d18 = par3 + d9;
         if (j == 2) {
            d10 = d11 = par2 + 0L;
            d12 = d13 = par2 + 1L;
            d14 = d17 = par4 + 1L;
            d15 = d16 = par4 + 0L;
         } else if (j == 3) {
            d10 = d13 = par2 + 0L;
            d11 = d12 = par2 + 1L;
            d14 = d15 = par4 + 0L;
            d16 = d17 = par4 + 1L;
         } else if (j == 1) {
            d10 = d13 = par2 + 1L;
            d11 = d12 = par2 + 0L;
            d14 = d15 = par4 + 1L;
            d16 = d17 = par4 + 0L;
         }
      }

      if (useFix) {
         tessellator.addVertexWithUVNoOffset(d13, d18, d17, d5, d7);
         tessellator.addVertexWithUVNoOffset(d12, d18, d16, d5, d8);
         tessellator.addVertexWithUVNoOffset(d11, d18, d15, d6, d8);
         tessellator.addVertexWithUVNoOffset(d10, d18, d14, d6, d7);
      } else {
         tessellator.a(d13, d18, d17, d5, d7);
         tessellator.a(d12, d18, d16, d5, d8);
         tessellator.a(d11, d18, d15, d6, d8);
         tessellator.a(d10, d18, d14, d6, d7);
      }

      return true;
   }

   public void renderPistonBaseAllFaces(Block par1Block, long par2, int par3, long par4) {
      this.f = true;
      this.renderPistonBase(par1Block, par2, par3, par4, true);
      this.f = false;
   }

   private boolean renderPistonBase(Block par1Block, long par2, int par3, long par4, boolean par5) {
      int i = this.a.getBlockMetadata(par2, par3, par4);
      boolean flag = par5 || (i & 8) != 0;
      int j = BlockPistonBase.e(i);
      if (flag) {
         switch (j) {
            case 0:
               this.g = 3;
               this.h = 3;
               this.i = 3;
               this.j = 3;
               par1Block.a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
               break;
            case 1:
               par1Block.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
               break;
            case 2:
               this.i = 1;
               this.j = 2;
               par1Block.a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
               break;
            case 3:
               this.i = 2;
               this.j = 1;
               this.k = 3;
               this.l = 3;
               par1Block.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
               break;
            case 4:
               this.g = 1;
               this.h = 2;
               this.k = 2;
               this.l = 1;
               par1Block.a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
               break;
            case 5:
               this.g = 2;
               this.h = 1;
               this.k = 1;
               this.l = 2;
               par1Block.a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
         }

         this.renderStandardBlock(par1Block, par2, par3, par4);
         this.g = 0;
         this.h = 0;
         this.i = 0;
         this.j = 0;
         this.k = 0;
         this.l = 0;
         par1Block.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         switch (j) {
            case 0:
               this.g = 3;
               this.h = 3;
               this.i = 3;
               this.j = 3;
            case 1:
            default:
               break;
            case 2:
               this.i = 1;
               this.j = 2;
               break;
            case 3:
               this.i = 2;
               this.j = 1;
               this.k = 3;
               this.l = 3;
               break;
            case 4:
               this.g = 1;
               this.h = 2;
               this.k = 2;
               this.l = 1;
               break;
            case 5:
               this.g = 2;
               this.h = 1;
               this.k = 1;
               this.l = 2;
         }

         this.renderStandardBlock(par1Block, par2, par3, par4);
         this.g = 0;
         this.h = 0;
         this.i = 0;
         this.j = 0;
         this.k = 0;
         this.l = 0;
      }

      return true;
   }

   private void a(double par1, double par3, double par5, double par7, double par9, double par11, float par13, double par14) {
      int i = 108;
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      Tessellator tessellator = Tessellator.a;
      double d = (j + 0) / 256.0F;
      double d1 = (k + 0) / 256.0F;
      double d2 = (j + par14 - 0.01) / 256.0;
      double d3 = (k + 4.0F - 0.01) / 256.0;
      tessellator.a(par13, par13, par13);
      tessellator.a(par1, par7, par9, d2, d1);
      tessellator.a(par1, par5, par9, d, d1);
      tessellator.a(par3, par5, par11, d, d3);
      tessellator.a(par3, par7, par11, d2, d3);
   }

   private void b(double par1, double par3, double par5, double par7, double par9, double par11, float par13, double par14) {
      int i = 108;
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      Tessellator tessellator = Tessellator.a;
      double d = (j + 0) / 256.0F;
      double d1 = (k + 0) / 256.0F;
      double d2 = (j + par14 - 0.01) / 256.0;
      double d3 = (k + 4.0F - 0.01) / 256.0;
      tessellator.a(par13, par13, par13);
      tessellator.a(par1, par5, par11, d2, d1);
      tessellator.a(par1, par5, par9, d, d1);
      tessellator.a(par3, par7, par9, d, d3);
      tessellator.a(par3, par7, par11, d2, d3);
   }

   private void c(double par1, double par3, double par5, double par7, double par9, double par11, float par13, double par14) {
      int i = 108;
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      Tessellator tessellator = Tessellator.a;
      double d = (j + 0) / 256.0F;
      double d1 = (k + 0) / 256.0F;
      double d2 = (j + par14 - 0.01) / 256.0;
      double d3 = (k + 4.0F - 0.01) / 256.0;
      tessellator.a(par13, par13, par13);
      tessellator.a(par3, par5, par9, d2, d1);
      tessellator.a(par1, par5, par9, d, d1);
      tessellator.a(par1, par7, par11, d, d3);
      tessellator.a(par3, par7, par11, d2, d3);
   }

   private void renderPistonRodUDStripelands(double par1, double par3, double par5, double par7, double par9, double par11, float par13, double par14) {
      int i = 108;
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      Tessellator tessellator = Tessellator.a;
      double d = (j + 0) / 256.0F;
      double d1 = (k + 0) / 256.0F;
      double d2 = (j + par14 - 0.01) / 256.0;
      double d3 = (k + 4.0F - 0.01) / 256.0;
      tessellator.a(par13, par13, par13);
      tessellator.addVertexWithUVNoOffset(par1, par7, par9, d2, d1);
      tessellator.addVertexWithUVNoOffset(par1, par5, par9, d, d1);
      tessellator.addVertexWithUVNoOffset(par3, par5, par11, d, d3);
      tessellator.addVertexWithUVNoOffset(par3, par7, par11, d2, d3);
   }

   private void renderPistonRodSNStripelands(double par1, double par3, double par5, double par7, double par9, double par11, float par13, double par14) {
      int i = 108;
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      Tessellator tessellator = Tessellator.a;
      double d = (j + 0) / 256.0F;
      double d1 = (k + 0) / 256.0F;
      double d2 = (j + par14 - 0.01) / 256.0;
      double d3 = (k + 4.0F - 0.01) / 256.0;
      tessellator.a(par13, par13, par13);
      tessellator.addVertexWithUVNoOffset(par1, par5, par11, d2, d1);
      tessellator.addVertexWithUVNoOffset(par1, par5, par9, d, d1);
      tessellator.addVertexWithUVNoOffset(par3, par7, par9, d, d3);
      tessellator.addVertexWithUVNoOffset(par3, par7, par11, d2, d3);
   }

   private void renderPistonRodEWStripelands(double par1, double par3, double par5, double par7, double par9, double par11, float par13, double par14) {
      int i = 108;
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      Tessellator tessellator = Tessellator.a;
      double d = (j + 0) / 256.0F;
      double d1 = (k + 0) / 256.0F;
      double d2 = (j + par14 - 0.01) / 256.0;
      double d3 = (k + 4.0F - 0.01) / 256.0;
      tessellator.a(par13, par13, par13);
      tessellator.addVertexWithUVNoOffset(par3, par5, par9, d2, d1);
      tessellator.addVertexWithUVNoOffset(par1, par5, par9, d, d1);
      tessellator.addVertexWithUVNoOffset(par1, par7, par11, d, d3);
      tessellator.addVertexWithUVNoOffset(par3, par7, par11, d2, d3);
   }

   public void renderPistonExtensionAllFaces(Block par1Block, long par2, int par3, long par4, boolean par5) {
      this.f = true;
      this.renderPistonExtension(par1Block, par2, par3, par4, par5);
      this.f = false;
   }

   private boolean renderPistonExtension(Block par1Block, long par2, int par3, long par4, boolean par5) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      int i = this.a.getBlockMetadata(par2, par3, par4);
      int j = BlockPistonExtension.h(i);
      float f = par1Block.getBlockBrightness(this.a, par2, par3, par4);
      double f1 = par5 ? 1.0 : 0.5;
      double d = par5 ? 16.0 : 8.0;
      switch (j) {
         case 0:
            this.g = 3;
            this.h = 3;
            this.i = 3;
            this.j = 3;
            par1Block.a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            this.renderStandardBlock(par1Block, par2, par3, par4);
            if (useFix) {
               this.renderPistonRodUDStripelands(par2a + 0.375, par2a + 0.625, par3a + 0.25, par3a + 0.25 + f1, par4a + 0.625, par4a + 0.625, f * 0.8F, d);
               this.renderPistonRodUDStripelands(par2a + 0.625, par2a + 0.375, par3a + 0.25, par3a + 0.25 + f1, par4a + 0.375, par4a + 0.375, f * 0.8F, d);
               this.renderPistonRodUDStripelands(par2a + 0.375, par2a + 0.375, par3a + 0.25, par3a + 0.25 + f1, par4a + 0.375, par4a + 0.625, f * 0.6F, d);
               this.renderPistonRodUDStripelands(par2a + 0.625, par2a + 0.625, par3a + 0.25, par3a + 0.25 + f1, par4a + 0.625, par4a + 0.375, f * 0.6F, d);
            } else {
               this.a(par2 + 0.375, par2 + 0.625, par3 + 0.25, par3 + 0.25 + f1, par4 + 0.625, par4 + 0.625, f * 0.8F, d);
               this.a(par2 + 0.625, par2 + 0.375, par3 + 0.25, par3 + 0.25 + f1, par4 + 0.375, par4 + 0.375, f * 0.8F, d);
               this.a(par2 + 0.375, par2 + 0.375, par3 + 0.25, par3 + 0.25 + f1, par4 + 0.375, par4 + 0.625, f * 0.6F, d);
               this.a(par2 + 0.625, par2 + 0.625, par3 + 0.25, par3 + 0.25 + f1, par4 + 0.625, par4 + 0.375, f * 0.6F, d);
            }
            break;
         case 1:
            par1Block.a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            this.renderStandardBlock(par1Block, par2, par3, par4);
            if (useFix) {
               this.renderPistonRodUDStripelands(par2a + 0.375, par2a + 0.625, par3a + 0.75 - f1, par3a + 0.75, par4a + 0.625, par4a + 0.625, f * 0.8F, d);
               this.renderPistonRodUDStripelands(par2a + 0.625, par2a + 0.375, par3a + 0.75 - f1, par3a + 0.75, par4a + 0.375, par4a + 0.375, f * 0.8F, d);
               this.renderPistonRodUDStripelands(par2a + 0.375, par2a + 0.375, par3a + 0.75 - f1, par3a + 0.75, par4a + 0.375, par4a + 0.625, f * 0.6F, d);
               this.renderPistonRodUDStripelands(par2a + 0.625, par2a + 0.625, par3a + 0.75 - f1, par3a + 0.75, par4a + 0.625, par4a + 0.375, f * 0.6F, d);
            } else {
               this.a(par2 + 0.375, par2 + 0.625, par3 + 0.75 - f1, par3 + 0.75, par4 + 0.625, par4 + 0.625, f * 0.8F, d);
               this.a(par2 + 0.625, par2 + 0.375, par3 + 0.75 - f1, par3 + 0.75, par4 + 0.375, par4 + 0.375, f * 0.8F, d);
               this.a(par2 + 0.375, par2 + 0.375, par3 + 0.75 - f1, par3 + 0.75, par4 + 0.375, par4 + 0.625, f * 0.6F, d);
               this.a(par2 + 0.625, par2 + 0.625, par3 + 0.75 - f1, par3 + 0.75, par4 + 0.625, par4 + 0.375, f * 0.6F, d);
            }
            break;
         case 2:
            this.i = 1;
            this.j = 2;
            par1Block.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            this.renderStandardBlock(par1Block, par2, par3, par4);
            if (useFix) {
               this.renderPistonRodSNStripelands(par2a + 0.375, par2a + 0.375, par3a + 0.625, par3a + 0.375, par4a + 0.25, par4a + 0.25 + f1, f * 0.6F, d);
               this.renderPistonRodSNStripelands(par2a + 0.625, par2a + 0.625, par3a + 0.375, par3a + 0.625, par4a + 0.25, par4a + 0.25 + f1, f * 0.6F, d);
               this.renderPistonRodSNStripelands(par2a + 0.375, par2a + 0.625, par3a + 0.375, par3a + 0.375, par4a + 0.25, par4a + 0.25 + f1, f * 0.5F, d);
               this.renderPistonRodSNStripelands(par2a + 0.625, par2a + 0.375, par3a + 0.625, par3a + 0.625, par4a + 0.25, par4a + 0.25 + f1, f, d);
            } else {
               this.b(par2 + 0.375, par2 + 0.375, par3 + 0.625, par3 + 0.375, par4 + 0.25, par4 + 0.25 + f1, f * 0.6F, d);
               this.b(par2 + 0.625, par2 + 0.625, par3 + 0.375, par3 + 0.625, par4 + 0.25, par4 + 0.25 + f1, f * 0.6F, d);
               this.b(par2 + 0.375, par2 + 0.625, par3 + 0.375, par3 + 0.375, par4 + 0.25, par4 + 0.25 + f1, f * 0.5F, d);
               this.b(par2 + 0.625, par2 + 0.375, par3 + 0.625, par3 + 0.625, par4 + 0.25, par4 + 0.25 + f1, f, d);
            }
            break;
         case 3:
            this.i = 2;
            this.j = 1;
            this.k = 3;
            this.l = 3;
            par1Block.a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            this.renderStandardBlock(par1Block, par2, par3, par4);
            if (useFix) {
               this.renderPistonRodSNStripelands(par2a + 0.375, par2a + 0.375, par3a + 0.625, par3a + 0.375, par4a + 0.75 - f1, par4a + 0.75, f * 0.6F, d);
               this.renderPistonRodSNStripelands(par2a + 0.625, par2a + 0.625, par3a + 0.375, par3a + 0.625, par4a + 0.75 - f1, par4a + 0.75, f * 0.6F, d);
               this.renderPistonRodSNStripelands(par2a + 0.375, par2a + 0.625, par3a + 0.375, par3a + 0.375, par4a + 0.75 - f1, par4a + 0.75, f * 0.5F, d);
               this.renderPistonRodSNStripelands(par2a + 0.625, par2a + 0.375, par3a + 0.625, par3a + 0.625, par4a + 0.75 - f1, par4a + 0.75, f, d);
            } else {
               this.b(par2 + 0.375, par2 + 0.375, par3 + 0.625, par3 + 0.375, par4 + 0.75 - f1, par4 + 0.75, f * 0.6F, d);
               this.b(par2 + 0.625, par2 + 0.625, par3 + 0.375, par3 + 0.625, par4 + 0.75 - f1, par4 + 0.75, f * 0.6F, d);
               this.b(par2 + 0.375, par2 + 0.625, par3 + 0.375, par3 + 0.375, par4 + 0.75 - f1, par4 + 0.75, f * 0.5F, d);
               this.b(par2 + 0.625, par2 + 0.375, par3 + 0.625, par3 + 0.625, par4 + 0.75 - f1, par4 + 0.75, f, d);
            }
            break;
         case 4:
            this.g = 1;
            this.h = 2;
            this.k = 2;
            this.l = 1;
            par1Block.a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            this.renderStandardBlock(par1Block, par2, par3, par4);
            if (useFix) {
               this.renderPistonRodEWStripelands(par2a + 0.25, par2a + 0.25 + f1, par3a + 0.375, par3a + 0.375, par4a + 0.625, par4a + 0.375, f * 0.5F, d);
               this.renderPistonRodEWStripelands(par2a + 0.25, par2a + 0.25 + f1, par3a + 0.625, par3a + 0.625, par4a + 0.375, par4a + 0.625, f, d);
               this.renderPistonRodEWStripelands(par2a + 0.25, par2a + 0.25 + f1, par3a + 0.375, par3a + 0.625, par4a + 0.375, par4a + 0.375, f * 0.6F, d);
               this.renderPistonRodEWStripelands(par2a + 0.25, par2a + 0.25 + f1, par3a + 0.625, par3a + 0.375, par4a + 0.625, par4a + 0.625, f * 0.6F, d);
            } else {
               this.c(par2 + 0.25, par2 + 0.25 + f1, par3 + 0.375, par3 + 0.375, par4 + 0.625, par4 + 0.375, f * 0.5F, d);
               this.c(par2 + 0.25, par2 + 0.25 + f1, par3 + 0.625, par3 + 0.625, par4 + 0.375, par4 + 0.625, f, d);
               this.c(par2 + 0.25, par2 + 0.25 + f1, par3 + 0.375, par3 + 0.625, par4 + 0.375, par4 + 0.375, f * 0.6F, d);
               this.c(par2 + 0.25, par2 + 0.25 + f1, par3 + 0.625, par3 + 0.375, par4 + 0.625, par4 + 0.625, f * 0.6F, d);
            }
            break;
         case 5:
            this.g = 2;
            this.h = 1;
            this.k = 1;
            this.l = 2;
            par1Block.a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            this.renderStandardBlock(par1Block, par2, par3, par4);
            if (useFix) {
               this.renderPistonRodEWStripelands(par2a + 0.75 - f1, par2a + 0.75, par3a + 0.375, par3a + 0.375, par4a + 0.625, par4a + 0.375, f * 0.5F, d);
               this.renderPistonRodEWStripelands(par2a + 0.75 - f1, par2a + 0.75, par3a + 0.625, par3a + 0.625, par4a + 0.375, par4a + 0.625, f, d);
               this.renderPistonRodEWStripelands(par2a + 0.75 - f1, par2a + 0.75, par3a + 0.375, par3a + 0.625, par4a + 0.375, par4a + 0.375, f * 0.6F, d);
               this.renderPistonRodEWStripelands(par2a + 0.75 - f1, par2a + 0.75, par3a + 0.625, par3a + 0.375, par4a + 0.625, par4a + 0.625, f * 0.6F, d);
            } else {
               this.c(par2 + 0.75 - f1, par2 + 0.75, par3 + 0.375, par3 + 0.375, par4 + 0.625, par4 + 0.375, f * 0.5F, d);
               this.c(par2 + 0.75 - f1, par2 + 0.75, par3 + 0.625, par3 + 0.625, par4 + 0.375, par4 + 0.625, f, d);
               this.c(par2 + 0.75 - f1, par2 + 0.75, par3 + 0.375, par3 + 0.625, par4 + 0.375, par4 + 0.375, f * 0.6F, d);
               this.c(par2 + 0.75 - f1, par2 + 0.75, par3 + 0.625, par3 + 0.375, par4 + 0.625, par4 + 0.625, f * 0.6F, d);
            }
      }

      this.g = 0;
      this.h = 0;
      this.i = 0;
      this.j = 0;
      this.k = 0;
      this.l = 0;
      par1Block.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      return true;
   }

   public boolean renderBlockLever(Block par1Block, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      int i = this.a.getBlockMetadata(par2, par3, par4);
      int j = i & 7;
      boolean flag = (i & 8) > 0;
      Tessellator tessellator = Tessellator.a;
      boolean flag1 = this.d >= 0;
      if (!flag1) {
         this.d = Block.w.bN;
      }

      float f = 0.25F;
      float f1 = 0.1875F;
      float f2 = 0.1875F;
      if (j == 5) {
         par1Block.a(0.5F - f1, 0.0F, 0.5F - f, 0.5F + f1, f2, 0.5F + f);
      } else if (j == 6) {
         par1Block.a(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, f2, 0.5F + f1);
      } else if (j == 4) {
         par1Block.a(0.5F - f1, 0.5F - f, 1.0F - f2, 0.5F + f1, 0.5F + f, 1.0F);
      } else if (j == 3) {
         par1Block.a(0.5F - f1, 0.5F - f, 0.0F, 0.5F + f1, 0.5F + f, f2);
      } else if (j == 2) {
         par1Block.a(1.0F - f2, 0.5F - f, 0.5F - f1, 1.0F, 0.5F + f, 0.5F + f1);
      } else if (j == 1) {
         par1Block.a(0.0F, 0.5F - f, 0.5F - f1, f2, 0.5F + f, 0.5F + f1);
      }

      this.renderStandardBlock(par1Block, par2, par3, par4);
      if (!flag1) {
         this.d = -1;
      }

      tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      float f3 = 1.0F;
      if (Block.q[par1Block.bO] > 0) {
         f3 = 1.0F;
      }

      tessellator.a(f3, f3, f3);
      int k = par1Block.a_(0);
      if (this.d >= 0) {
         k = this.d;
      }

      int l = (k & 15) << 4;
      int i1 = k & 240;
      float f4 = l / 256.0F;
      float f5 = (l + 15.99F) / 256.0F;
      float f6 = i1 / 256.0F;
      float f7 = (i1 + 15.99F) / 256.0F;
      bo[] avec3d = new bo[8];
      float f8 = 0.0625F;
      float f9 = 0.0625F;
      float f10 = 0.625F;
      avec3d[0] = bo.b(-f8, 0.0, -f9);
      avec3d[1] = bo.b(f8, 0.0, -f9);
      avec3d[2] = bo.b(f8, 0.0, f9);
      avec3d[3] = bo.b(-f8, 0.0, f9);
      avec3d[4] = bo.b(-f8, f10, -f9);
      avec3d[5] = bo.b(f8, f10, -f9);
      avec3d[6] = bo.b(f8, f10, f9);
      avec3d[7] = bo.b(-f8, f10, f9);

      for (int j1 = 0; j1 < 8; j1++) {
         if (flag) {
            avec3d[j1].c -= 0.0625;
            avec3d[j1].a((float) Math.PI * 2.0F / 9.0F);
         } else {
            avec3d[j1].c += 0.0625;
            avec3d[j1].a((float) -Math.PI * 2.0F / 9.0F);
         }

         if (j == 6) {
            avec3d[j1].b((float) (Math.PI / 2));
         }

         if (j < 5) {
            avec3d[j1].b -= 0.375;
            avec3d[j1].a((float) (Math.PI / 2));
            if (j == 4) {
               avec3d[j1].b(0.0F);
            }

            if (j == 3) {
               avec3d[j1].b((float) Math.PI);
            }

            if (j == 2) {
               avec3d[j1].b((float) (Math.PI / 2));
            }

            if (j == 1) {
               avec3d[j1].b((float) (-Math.PI / 2));
            }

            if (useFix) {
               avec3d[j1].a += par2a + 0.5;
               avec3d[j1].b += par3a + 0.5;
               avec3d[j1].c += par4a + 0.5;
            } else {
               avec3d[j1].a += par2 + 0.5;
               avec3d[j1].b += par3 + 0.5;
               avec3d[j1].c += par4 + 0.5;
            }
         } else if (useFix) {
            avec3d[j1].a += par2a + 0.5;
            avec3d[j1].b += par3a + 0.125;
            avec3d[j1].c += par4a + 0.5;
         } else {
            avec3d[j1].a += par2 + 0.5;
            avec3d[j1].b += par3 + 0.125;
            avec3d[j1].c += par4 + 0.5;
         }
      }

      bo vec3d = null;
      bo vec3d1 = null;
      bo vec3d2 = null;
      bo vec3d3 = null;

      for (int k1 = 0; k1 < 6; k1++) {
         if (k1 == 0) {
            f4 = (l + 7) / 256.0F;
            f5 = (l + 9 - 0.01F) / 256.0F;
            f6 = (i1 + 6) / 256.0F;
            f7 = (i1 + 8 - 0.01F) / 256.0F;
         } else if (k1 == 2) {
            f4 = (l + 7) / 256.0F;
            f5 = (l + 9 - 0.01F) / 256.0F;
            f6 = (i1 + 6) / 256.0F;
            f7 = (i1 + 16 - 0.01F) / 256.0F;
         }

         if (k1 == 0) {
            vec3d = avec3d[0];
            vec3d1 = avec3d[1];
            vec3d2 = avec3d[2];
            vec3d3 = avec3d[3];
         } else if (k1 == 1) {
            vec3d = avec3d[7];
            vec3d1 = avec3d[6];
            vec3d2 = avec3d[5];
            vec3d3 = avec3d[4];
         } else if (k1 == 2) {
            vec3d = avec3d[1];
            vec3d1 = avec3d[0];
            vec3d2 = avec3d[4];
            vec3d3 = avec3d[5];
         } else if (k1 == 3) {
            vec3d = avec3d[2];
            vec3d1 = avec3d[1];
            vec3d2 = avec3d[5];
            vec3d3 = avec3d[6];
         } else if (k1 == 4) {
            vec3d = avec3d[3];
            vec3d1 = avec3d[2];
            vec3d2 = avec3d[6];
            vec3d3 = avec3d[7];
         } else if (k1 == 5) {
            vec3d = avec3d[0];
            vec3d1 = avec3d[3];
            vec3d2 = avec3d[7];
            vec3d3 = avec3d[4];
         }

         if (useFix) {
            tessellator.addVertexWithUVNoOffset(vec3d.a, vec3d.b, vec3d.c, f4, f7);
            tessellator.addVertexWithUVNoOffset(vec3d1.a, vec3d1.b, vec3d1.c, f5, f7);
            tessellator.addVertexWithUVNoOffset(vec3d2.a, vec3d2.b, vec3d2.c, f5, f6);
            tessellator.addVertexWithUVNoOffset(vec3d3.a, vec3d3.b, vec3d3.c, f4, f6);
         } else {
            tessellator.a(vec3d.a, vec3d.b, vec3d.c, f4, f7);
            tessellator.a(vec3d1.a, vec3d1.b, vec3d1.c, f5, f7);
            tessellator.a(vec3d2.a, vec3d2.b, vec3d2.c, f5, f6);
            tessellator.a(vec3d3.a, vec3d3.b, vec3d3.c, f4, f6);
         }
      }

      return true;
   }

   public boolean renderBlockFire(Block par1Block, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.a_(0);
      if (this.d >= 0) {
         i = this.d;
      }

      tessellator.a(1.0F, 1.0F, 1.0F);
      tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      int j = (i & 15) << 4;
      int k = i & 240;
      double d = j / 256.0F;
      double d2 = (j + 15.99F) / 256.0F;
      double d4 = k / 256.0F;
      double d6 = (k + 15.99F) / 256.0F;
      float f = 1.4F;
      if (!this.a.isBlockNormalCube(par2, par3 - 1, par4) && !Block.ar.canBlockCatchFire(this.a, par2, par3 - 1, par4)) {
         double f2 = 0.2;
         double f3 = 0.0625;
         if ((par2 + par3 + par4 & 1L) == 1L) {
            d = j / 256.0F;
            d2 = (j + 15.99F) / 256.0F;
            d4 = (k + 16) / 256.0F;
            d6 = (k + 15.99F + 16.0F) / 256.0F;
         }

         if ((par2 / 2L + par3 / 2 + par4 / 2L & 1L) == 1L) {
            double d10 = d2;
            d2 = d;
            d = d10;
         }

         if (Block.ar.canBlockCatchFire(this.a, par2 - 1L, par3, par4)) {
            if (useFix) {
               tessellator.addVertexWithUVNoOffset(par2a + f2, par3a + (f + f3), par4a + 1L, d2, d4);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + f3, par4a + 1L, d2, d6);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + f3, par4a, d, d6);
               tessellator.addVertexWithUVNoOffset(par2a + f2, par3a + (f + f3), par4a, d, d4);
               tessellator.addVertexWithUVNoOffset(par2a + f2, par3a + (f + f3), par4a, d, d4);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + f3, par4a, d, d6);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + f3, par4a + 1L, d2, d6);
               tessellator.addVertexWithUVNoOffset(par2a + f2, par3a + (f + f3), par4a + 1L, d2, d4);
            } else {
               tessellator.a(par2 + f2, par3 + (f + f3), par4 + 1L, d2, d4);
               tessellator.a(par2, par3 + f3, par4 + 1L, d2, d6);
               tessellator.a(par2, par3 + f3, par4, d, d6);
               tessellator.a(par2 + f2, par3 + (f + f3), par4, d, d4);
               tessellator.a(par2 + f2, par3 + (f + f3), par4, d, d4);
               tessellator.a(par2, par3 + f3, par4, d, d6);
               tessellator.a(par2, par3 + f3, par4 + 1L, d2, d6);
               tessellator.a(par2 + f2, par3 + (f + f3), par4 + 1L, d2, d4);
            }
         }

         if (Block.ar.canBlockCatchFire(this.a, par2 + 1L, par3, par4)) {
            if (useFix) {
               tessellator.addVertexWithUVNoOffset(par2a + 1L - f2, par3a + (f + f3), par4a, d, d4);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f3, par4a, d, d6);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f3, par4a + 1L, d2, d6);
               tessellator.addVertexWithUVNoOffset(par2a + 1L - f2, par3a + (f + f3), par4a + 1L, d2, d4);
               tessellator.addVertexWithUVNoOffset(par2a + 1L - f2, par3a + (f + f3), par4a + 1L, d2, d4);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f3, par4a + 1L, d2, d6);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f3, par4a, d, d6);
               tessellator.addVertexWithUVNoOffset(par2a + 1L - f2, par3a + (f + f3), par4a, d, d4);
            } else {
               tessellator.a(par2 + 1L - f2, par3 + (f + f3), par4, d, d4);
               tessellator.a(par2 + 1L, par3 + f3, par4, d, d6);
               tessellator.a(par2 + 1L, par3 + f3, par4 + 1L, d2, d6);
               tessellator.a(par2 + 1L - f2, par3 + (f + f3), par4 + 1L, d2, d4);
               tessellator.a(par2 + 1L - f2, par3 + (f + f3), par4 + 1L, d2, d4);
               tessellator.a(par2 + 1L, par3 + f3, par4 + 1L, d2, d6);
               tessellator.a(par2 + 1L, par3 + f3, par4, d, d6);
               tessellator.a(par2 + 1L - f2, par3 + (f + f3), par4, d, d4);
            }
         }

         if (Block.ar.canBlockCatchFire(this.a, par2, par3, par4 - 1L)) {
            if (useFix) {
               tessellator.addVertexWithUVNoOffset(par2a, par3a + (f + f3), par4a + f2, d2, d4);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + f3, par4a, d2, d6);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f3, par4a, d, d6);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + (f + f3), par4a + f2, d, d4);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + (f + f3), par4a + f2, d, d4);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f3, par4a, d, d6);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + f3, par4a, d2, d6);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + (f + f3), par4a + f2, d2, d4);
            } else {
               tessellator.a(par2, par3 + (f + f3), par4 + f2, d2, d4);
               tessellator.a(par2, par3 + f3, par4, d2, d6);
               tessellator.a(par2 + 1L, par3 + f3, par4, d, d6);
               tessellator.a(par2 + 1L, par3 + (f + f3), par4 + f2, d, d4);
               tessellator.a(par2 + 1L, par3 + (f + f3), par4 + f2, d, d4);
               tessellator.a(par2 + 1L, par3 + f3, par4, d, d6);
               tessellator.a(par2, par3 + f3, par4, d2, d6);
               tessellator.a(par2, par3 + (f + f3), par4 + f2, d2, d4);
            }
         }

         if (Block.ar.canBlockCatchFire(this.a, par2, par3, par4 + 1L)) {
            if (useFix) {
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + (f + f3), par4a + 1L - f2, d, d4);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f3, par4a + 1L, d, d6);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + f3, par4a + 1L, d2, d6);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + (f + f3), par4a + 1L - f2, d2, d4);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + (f + f3), par4a + 1L - f2, d2, d4);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + f3, par4a + 1L, d2, d6);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f3, par4a + 1L, d, d6);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + (f + f3), par4a + 1L - f2, d, d4);
            } else {
               tessellator.a(par2 + 1L, par3 + (f + f3), par4 + 1L - f2, d, d4);
               tessellator.a(par2 + 1L, par3 + f3, par4 + 1L, d, d6);
               tessellator.a(par2, par3 + f3, par4 + 1L, d2, d6);
               tessellator.a(par2, par3 + (f + f3), par4 + 1L - f2, d2, d4);
               tessellator.a(par2, par3 + (f + f3), par4 + 1L - f2, d2, d4);
               tessellator.a(par2, par3 + f3, par4 + 1L, d2, d6);
               tessellator.a(par2 + 1L, par3 + f3, par4 + 1L, d, d6);
               tessellator.a(par2 + 1L, par3 + (f + f3), par4 + 1L - f2, d, d4);
            }
         }

         if (Block.ar.canBlockCatchFire(this.a, par2, par3 + 1, par4)) {
            long d11 = par2 + 1L;
            long d13 = par2;
            long d15 = par4 + 1L;
            long d17 = par4;
            long d19 = par2;
            long d21 = par2 + 1L;
            long d23 = par4;
            long d24 = par4 + 1L;
            if (useFix) {
               d11 = par2a + 1L;
               d13 = par2a;
               d15 = par4a + 1L;
               d17 = par4a;
               d19 = par2a;
               d21 = par2a + 1L;
               d23 = par4a;
               d24 = par4a + 1L;
            }

            double d1 = j / 256.0F;
            double d3 = (j + 15.99F) / 256.0F;
            double d5 = k / 256.0F;
            double d7 = (k + 15.99F) / 256.0F;
            par3++;
            float f1 = -0.2F;
            if ((par2 + par3 + par4 & 1L) == 0L) {
               if (useFix) {
                  tessellator.addVertexWithUVNoOffset(d19, par3a + f1, par4a, d3, d5);
                  tessellator.addVertexWithUVNoOffset(d11, par3a, par4a, d3, d7);
                  tessellator.addVertexWithUVNoOffset(d11, par3a, par4a + 1L, d1, d7);
                  tessellator.addVertexWithUVNoOffset(d19, par3a + f1, par4a + 1L, d1, d5);
               } else {
                  tessellator.a(d19, par3 + f1, par4, d3, d5);
                  tessellator.a(d11, par3, par4, d3, d7);
                  tessellator.a(d11, par3, par4 + 1L, d1, d7);
                  tessellator.a(d19, par3 + f1, par4 + 1L, d1, d5);
               }

               d1 = j / 256.0F;
               d3 = (j + 15.99F) / 256.0F;
               d5 = (k + 16) / 256.0F;
               d7 = (k + 15.99F + 16.0F) / 256.0F;
               if (useFix) {
                  tessellator.addVertexWithUVNoOffset(d21, par3a + f1, par4a + 1L, d3, d5);
                  tessellator.addVertexWithUVNoOffset(d13, par3a, par4a + 1L, d3, d7);
                  tessellator.addVertexWithUVNoOffset(d13, par3a, par4a, d1, d7);
                  tessellator.addVertexWithUVNoOffset(d21, par3a + f1, par4a, d1, d5);
               } else {
                  tessellator.a(d21, par3 + f1, par4 + 1L, d3, d5);
                  tessellator.a(d13, par3, par4 + 1L, d3, d7);
                  tessellator.a(d13, par3, par4, d1, d7);
                  tessellator.a(d21, par3 + f1, par4, d1, d5);
               }
            } else {
               if (useFix) {
                  tessellator.addVertexWithUVNoOffset(par2a, par3a + f1, d24, d3, d5);
                  tessellator.addVertexWithUVNoOffset(par2a, par3a, d17, d3, d7);
                  tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, d17, d1, d7);
                  tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f1, d24, d1, d5);
               } else {
                  tessellator.a(par2, par3 + f1, d24, d3, d5);
                  tessellator.a(par2, par3, d17, d3, d7);
                  tessellator.a(par2 + 1L, par3, d17, d1, d7);
                  tessellator.a(par2 + 1L, par3 + f1, d24, d1, d5);
               }

               d1 = j / 256.0F;
               d3 = (j + 15.99F) / 256.0F;
               d5 = (k + 16) / 256.0F;
               d7 = (k + 15.99F + 16.0F) / 256.0F;
               if (useFix) {
                  tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f1, d23, d3, d5);
                  tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, d15, d3, d7);
                  tessellator.addVertexWithUVNoOffset(par2a, par3a, d15, d1, d7);
                  tessellator.addVertexWithUVNoOffset(par2a, par3a + f1, d23, d1, d5);
               } else {
                  tessellator.a(par2 + 1L, par3 + f1, d23, d3, d5);
                  tessellator.a(par2 + 1L, par3, d15, d3, d7);
                  tessellator.a(par2, par3, d15, d1, d7);
                  tessellator.a(par2, par3 + f1, d23, d1, d5);
               }
            }
         }
      } else {
         double d8 = par2 + 0.7;
         double d9 = par2 + 0.3;
         double d12 = par4 + 0.7;
         double d14 = par4 + 0.3;
         double d16 = par2 + 0.2;
         double d18 = par2 + 0.8;
         double d20 = par4 + 0.2;
         double d22 = par4 + 0.8;
         if (useFix) {
            d8 = par2a + 0.7;
            d9 = par2a + 0.3;
            d12 = par4a + 0.7;
            d14 = par4a + 0.3;
            d16 = par2a + 0.2;
            d18 = par2a + 0.8;
            d20 = par4a + 0.2;
            d22 = par4a + 0.8;
            tessellator.addVertexWithUVNoOffset(d16, par3a + f, par4a + 1L, d2, d4);
            tessellator.addVertexWithUVNoOffset(d8, par3a, par4a + 1L, d2, d6);
            tessellator.addVertexWithUVNoOffset(d8, par3a, par4a, d, d6);
            tessellator.addVertexWithUVNoOffset(d16, par3a + f, par4a, d, d4);
            tessellator.addVertexWithUVNoOffset(d18, par3a + f, par4a, d2, d4);
            tessellator.addVertexWithUVNoOffset(d9, par3a, par4a, d2, d6);
            tessellator.addVertexWithUVNoOffset(d9, par3a, par4a + 1L, d, d6);
            tessellator.addVertexWithUVNoOffset(d18, par3a + f, par4a + 1L, d, d4);
         } else {
            tessellator.a(d16, par3 + f, par4 + 1L, d2, d4);
            tessellator.a(d8, par3, par4 + 1L, d2, d6);
            tessellator.a(d8, par3, par4, d, d6);
            tessellator.a(d16, par3 + f, par4, d, d4);
            tessellator.a(d18, par3 + f, par4, d2, d4);
            tessellator.a(d9, par3, par4, d2, d6);
            tessellator.a(d9, par3, par4 + 1L, d, d6);
            tessellator.a(d18, par3 + f, par4 + 1L, d, d4);
         }

         d = j / 256.0F;
         d2 = (j + 15.99F) / 256.0F;
         d4 = (k + 16) / 256.0F;
         d6 = (k + 15.99F + 16.0F) / 256.0F;
         if (useFix) {
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f, d22, d2, d4);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, d14, d2, d6);
            tessellator.addVertexWithUVNoOffset(par2a, par3a, d14, d, d6);
            tessellator.addVertexWithUVNoOffset(par2a, par3a + f, d22, d, d4);
            tessellator.addVertexWithUVNoOffset(par2a, par3a + f, d20, d2, d4);
            tessellator.addVertexWithUVNoOffset(par2a, par3a, d12, d2, d6);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, d12, d, d6);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f, d20, d, d4);
         } else {
            tessellator.a(par2 + 1L, par3 + f, d22, d2, d4);
            tessellator.a(par2 + 1L, par3, d14, d2, d6);
            tessellator.a(par2, par3, d14, d, d6);
            tessellator.a(par2, par3 + f, d22, d, d4);
            tessellator.a(par2, par3 + f, d20, d2, d4);
            tessellator.a(par2, par3, d12, d2, d6);
            tessellator.a(par2 + 1L, par3, d12, d, d6);
            tessellator.a(par2 + 1L, par3 + f, d20, d, d4);
         }

         d8 = par2;
         d9 = par2 + 1L;
         d12 = par4;
         d14 = par4 + 1L;
         d16 = par2 + 0.1;
         d18 = par2 + 0.9;
         d20 = par4 + 0.1;
         d22 = par4 + 0.9;
         if (useFix) {
            d8 = par2a;
            d9 = par2a + 1L;
            d12 = par4a;
            d14 = par4a + 1L;
            d16 = par2a + 0.1;
            d18 = par2a + 0.9;
            d20 = par4a + 0.1;
            d22 = par4a + 0.9;
            tessellator.addVertexWithUVNoOffset(d16, par3a + f, par4a, d, d4);
            tessellator.addVertexWithUVNoOffset(d8, par3a, par4a, d, d6);
            tessellator.addVertexWithUVNoOffset(d8, par3a, par4a + 1L, d2, d6);
            tessellator.addVertexWithUVNoOffset(d16, par3a + f, par4a + 1L, d2, d4);
            tessellator.addVertexWithUVNoOffset(d18, par3a + f, par4a + 1L, d, d4);
            tessellator.addVertexWithUVNoOffset(d9, par3a, par4a + 1L, d, d6);
            tessellator.addVertexWithUVNoOffset(d9, par3a, par4a, d2, d6);
            tessellator.addVertexWithUVNoOffset(d18, par3a + f, par4a, d2, d4);
         } else {
            tessellator.a(d16, par3 + f, par4, d, d4);
            tessellator.a(d8, par3, par4, d, d6);
            tessellator.a(d8, par3, par4 + 1L, d2, d6);
            tessellator.a(d16, par3 + f, par4 + 1L, d2, d4);
            tessellator.a(d18, par3 + f, par4 + 1L, d, d4);
            tessellator.a(d9, par3, par4 + 1L, d, d6);
            tessellator.a(d9, par3, par4, d2, d6);
            tessellator.a(d18, par3 + f, par4, d2, d4);
         }

         d = j / 256.0F;
         d2 = (j + 15.99F) / 256.0F;
         d4 = k / 256.0F;
         d6 = (k + 15.99F) / 256.0F;
         if (useFix) {
            tessellator.addVertexWithUVNoOffset(par2a, par3a + f, d22, d, d4);
            tessellator.addVertexWithUVNoOffset(par2a, par3a, d14, d, d6);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, d14, d2, d6);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f, d22, d2, d4);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + f, d20, d, d4);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, d12, d, d6);
            tessellator.addVertexWithUVNoOffset(par2a, par3a, d12, d2, d6);
            tessellator.addVertexWithUVNoOffset(par2a, par3a + f, d20, d2, d4);
         } else {
            tessellator.a(par2, par3 + f, d22, d, d4);
            tessellator.a(par2, par3, d14, d, d6);
            tessellator.a(par2 + 1L, par3, d14, d2, d6);
            tessellator.a(par2 + 1L, par3 + f, d22, d2, d4);
            tessellator.a(par2 + 1L, par3 + f, d20, d, d4);
            tessellator.a(par2 + 1L, par3, d12, d, d6);
            tessellator.a(par2, par3, d12, d2, d6);
            tessellator.a(par2, par3 + f, d20, d2, d4);
         }
      }

      return true;
   }

   public boolean renderBlockRedstoneWire(Block par1Block, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      Tessellator tessellator = Tessellator.a;
      int i = this.a.getBlockMetadata(par2, par3, par4);
      int j = par1Block.a(1, i);
      if (this.d >= 0) {
         j = this.d;
      }

      tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      float f = 1.0F;
      float f1 = i / 15.0F;
      float f2 = f1 * 0.6F + 0.4F;
      if (i == 0) {
         f2 = 0.3F;
      }

      float f3 = f1 * f1 * 0.7F - 0.5F;
      float f4 = f1 * f1 * 0.6F - 0.7F;
      if (f3 < 0.0F) {
         f3 = 0.0F;
      }

      if (f4 < 0.0F) {
         f4 = 0.0F;
      }

      tessellator.a(f2, f3, f4);
      int k = (j & 15) << 4;
      int l = j & 240;
      double d = k / 256.0F;
      double d2 = (k + 15.99F) / 256.0F;
      double d4 = l / 256.0F;
      double d6 = (l + 15.99F) / 256.0F;
      boolean flag = BlockRedstoneWire.isPowerProviderOrWire(this.a, par2 - 1L, par3, par4, 1)
         || !this.a.isBlockNormalCube(par2 - 1L, par3, par4) && BlockRedstoneWire.isPowerProviderOrWire(this.a, par2 - 1L, par3 - 1, par4, -1);
      boolean flag1 = BlockRedstoneWire.isPowerProviderOrWire(this.a, par2 + 1L, par3, par4, 3)
         || !this.a.isBlockNormalCube(par2 + 1L, par3, par4) && BlockRedstoneWire.isPowerProviderOrWire(this.a, par2 + 1L, par3 - 1, par4, -1);
      boolean flag2 = BlockRedstoneWire.isPowerProviderOrWire(this.a, par2, par3, par4 - 1L, 2)
         || !this.a.isBlockNormalCube(par2, par3, par4 - 1L) && BlockRedstoneWire.isPowerProviderOrWire(this.a, par2, par3 - 1, par4 - 1L, -1);
      boolean flag3 = BlockRedstoneWire.isPowerProviderOrWire(this.a, par2, par3, par4 + 1L, 0)
         || !this.a.isBlockNormalCube(par2, par3, par4 + 1L) && BlockRedstoneWire.isPowerProviderOrWire(this.a, par2, par3 - 1, par4 + 1L, -1);
      if (!this.a.isBlockNormalCube(par2, par3 + 1, par4)) {
         if (this.a.isBlockNormalCube(par2 - 1L, par3, par4) && BlockRedstoneWire.isPowerProviderOrWire(this.a, par2 - 1L, par3 + 1, par4, -1)) {
            flag = true;
         }

         if (this.a.isBlockNormalCube(par2 + 1L, par3, par4) && BlockRedstoneWire.isPowerProviderOrWire(this.a, par2 + 1L, par3 + 1, par4, -1)) {
            flag1 = true;
         }

         if (this.a.isBlockNormalCube(par2, par3, par4 - 1L) && BlockRedstoneWire.isPowerProviderOrWire(this.a, par2, par3 + 1, par4 - 1L, -1)) {
            flag2 = true;
         }

         if (this.a.isBlockNormalCube(par2, par3, par4 + 1L) && BlockRedstoneWire.isPowerProviderOrWire(this.a, par2, par3 + 1, par4 + 1L, -1)) {
            flag3 = true;
         }
      }

      double f5 = par2;
      double f6 = par2 + 1L;
      double f7 = par4;
      double f8 = par4 + 1L;
      if (useFix) {
         f5 = par2a;
         f6 = par2a + 1L;
         f7 = par4a;
         f8 = par4a + 1L;
      }

      byte byte0 = 0;
      if ((flag || flag1) && !flag2 && !flag3) {
         byte0 = 1;
      }

      if ((flag2 || flag3) && !flag1 && !flag) {
         byte0 = 2;
      }

      if (byte0 != 0) {
         d = (k + 16) / 256.0F;
         d2 = (k + 16 + 15.99F) / 256.0F;
         d4 = l / 256.0F;
         d6 = (l + 15.99F) / 256.0F;
      }

      if (byte0 == 0) {
         if (!flag) {
            f5 += 0.3125;
         }

         if (!flag) {
            d += 0.01953125;
         }

         if (!flag1) {
            f6 -= 0.3125;
         }

         if (!flag1) {
            d2 -= 0.01953125;
         }

         if (!flag2) {
            f7 += 0.3125;
         }

         if (!flag2) {
            d4 += 0.01953125;
         }

         if (!flag3) {
            f8 -= 0.3125;
         }

         if (!flag3) {
            d6 -= 0.01953125;
         }

         if (useFix) {
            tessellator.addVertexWithUVNoOffset(f6, par3a + 0.015625, f8, d2, d6);
            tessellator.addVertexWithUVNoOffset(f6, par3a + 0.015625, f7, d2, d4);
            tessellator.addVertexWithUVNoOffset(f5, par3a + 0.015625, f7, d, d4);
            tessellator.addVertexWithUVNoOffset(f5, par3a + 0.015625, f8, d, d6);
            tessellator.a(f, f, f);
            tessellator.addVertexWithUVNoOffset(f6, par3a + 0.015625, f8, d2, d6 + 0.0625);
            tessellator.addVertexWithUVNoOffset(f6, par3a + 0.015625, f7, d2, d4 + 0.0625);
            tessellator.addVertexWithUVNoOffset(f5, par3a + 0.015625, f7, d, d4 + 0.0625);
            tessellator.addVertexWithUVNoOffset(f5, par3a + 0.015625, f8, d, d6 + 0.0625);
         } else {
            tessellator.a(f6, par3 + 0.015625, f8, d2, d6);
            tessellator.a(f6, par3 + 0.015625, f7, d2, d4);
            tessellator.a(f5, par3 + 0.015625, f7, d, d4);
            tessellator.a(f5, par3 + 0.015625, f8, d, d6);
            tessellator.a(f, f, f);
            tessellator.a(f6, par3 + 0.015625, f8, d2, d6 + 0.0625);
            tessellator.a(f6, par3 + 0.015625, f7, d2, d4 + 0.0625);
            tessellator.a(f5, par3 + 0.015625, f7, d, d4 + 0.0625);
            tessellator.a(f5, par3 + 0.015625, f8, d, d6 + 0.0625);
         }
      } else if (byte0 == 1) {
         if (useFix) {
            tessellator.addVertexWithUVNoOffset(f6, par3a + 0.015625, f8, d2, d6);
            tessellator.addVertexWithUVNoOffset(f6, par3a + 0.015625, f7, d2, d4);
            tessellator.addVertexWithUVNoOffset(f5, par3a + 0.015625, f7, d, d4);
            tessellator.addVertexWithUVNoOffset(f5, par3a + 0.015625, f8, d, d6);
            tessellator.a(f, f, f);
            tessellator.addVertexWithUVNoOffset(f6, par3a + 0.015625, f8, d2, d6 + 0.0625);
            tessellator.addVertexWithUVNoOffset(f6, par3a + 0.015625, f7, d2, d4 + 0.0625);
            tessellator.addVertexWithUVNoOffset(f5, par3a + 0.015625, f7, d, d4 + 0.0625);
            tessellator.addVertexWithUVNoOffset(f5, par3a + 0.015625, f8, d, d6 + 0.0625);
         } else {
            tessellator.a(f6, par3 + 0.015625, f8, d2, d6);
            tessellator.a(f6, par3 + 0.015625, f7, d2, d4);
            tessellator.a(f5, par3 + 0.015625, f7, d, d4);
            tessellator.a(f5, par3 + 0.015625, f8, d, d6);
            tessellator.a(f, f, f);
            tessellator.a(f6, par3 + 0.015625, f8, d2, d6 + 0.0625);
            tessellator.a(f6, par3 + 0.015625, f7, d2, d4 + 0.0625);
            tessellator.a(f5, par3 + 0.015625, f7, d, d4 + 0.0625);
            tessellator.a(f5, par3 + 0.015625, f8, d, d6 + 0.0625);
         }
      } else if (byte0 == 2) {
         if (useFix) {
            tessellator.addVertexWithUVNoOffset(f6, par3a + 0.015625, f8, d2, d6);
            tessellator.addVertexWithUVNoOffset(f6, par3a + 0.015625, f7, d, d6);
            tessellator.addVertexWithUVNoOffset(f5, par3a + 0.015625, f7, d, d4);
            tessellator.addVertexWithUVNoOffset(f5, par3a + 0.015625, f8, d2, d4);
            tessellator.a(f, f, f);
            tessellator.addVertexWithUVNoOffset(f6, par3a + 0.015625, f8, d2, d6 + 0.0625);
            tessellator.addVertexWithUVNoOffset(f6, par3a + 0.015625, f7, d, d6 + 0.0625);
            tessellator.addVertexWithUVNoOffset(f5, par3a + 0.015625, f7, d, d4 + 0.0625);
            tessellator.addVertexWithUVNoOffset(f5, par3a + 0.015625, f8, d2, d4 + 0.0625);
         } else {
            tessellator.a(f6, par3 + 0.015625, f8, d2, d6);
            tessellator.a(f6, par3 + 0.015625, f7, d, d6);
            tessellator.a(f5, par3 + 0.015625, f7, d, d4);
            tessellator.a(f5, par3 + 0.015625, f8, d2, d4);
            tessellator.a(f, f, f);
            tessellator.a(f6, par3 + 0.015625, f8, d2, d6 + 0.0625);
            tessellator.a(f6, par3 + 0.015625, f7, d, d6 + 0.0625);
            tessellator.a(f5, par3 + 0.015625, f7, d, d4 + 0.0625);
            tessellator.a(f5, par3 + 0.015625, f8, d2, d4 + 0.0625);
         }
      }

      if (!this.a.isBlockNormalCube(par2, par3 + 1, par4)) {
         double d1 = (k + 16) / 256.0F;
         double d3 = (k + 16 + 15.99F) / 256.0F;
         double d5 = l / 256.0F;
         double d7 = (l + 15.99F) / 256.0F;
         if (this.a.isBlockNormalCube(par2 - 1L, par3, par4) && this.a.getBlockId(par2 - 1L, par3 + 1, par4) == Block.EntityThrowable.bO) {
            if (useFix) {
               tessellator.a(f * f2, f * f3, f * f4);
               tessellator.addVertexWithUVNoOffset(par2a + 0.015625, par3a + 1.021875, par4a + 1L, d3, d5);
               tessellator.addVertexWithUVNoOffset(par2a + 0.015625, par3a, par4a + 1L, d1, d5);
               tessellator.addVertexWithUVNoOffset(par2a + 0.015625, par3a, par4a, d1, d7);
               tessellator.addVertexWithUVNoOffset(par2a + 0.015625, par3a + 1.021875, par4a, d3, d7);
               tessellator.a(f, f, f);
               tessellator.addVertexWithUVNoOffset(par2a + 0.015625, par3a + 1.021875, par4a + 1L, d3, d5 + 0.0625);
               tessellator.addVertexWithUVNoOffset(par2a + 0.015625, par3a, par4a + 1L, d1, d5 + 0.0625);
               tessellator.addVertexWithUVNoOffset(par2a + 0.015625, par3a, par4a, d1, d7 + 0.0625);
               tessellator.addVertexWithUVNoOffset(par2a + 0.015625, par3a + 1.021875, par4a, d3, d7 + 0.0625);
            } else {
               tessellator.a(f * f2, f * f3, f * f4);
               tessellator.a(par2 + 0.015625, par3 + 1.021875, par4 + 1L, d3, d5);
               tessellator.a(par2 + 0.015625, par3, par4 + 1L, d1, d5);
               tessellator.a(par2 + 0.015625, par3, par4, d1, d7);
               tessellator.a(par2 + 0.015625, par3 + 1.021875, par4, d3, d7);
               tessellator.a(f, f, f);
               tessellator.a(par2 + 0.015625, par3 + 1.021875, par4 + 1L, d3, d5 + 0.0625);
               tessellator.a(par2 + 0.015625, par3, par4 + 1L, d1, d5 + 0.0625);
               tessellator.a(par2 + 0.015625, par3, par4, d1, d7 + 0.0625);
               tessellator.a(par2 + 0.015625, par3 + 1.021875, par4, d3, d7 + 0.0625);
            }
         }

         if (this.a.isBlockNormalCube(par2 + 1L, par3, par4) && this.a.getBlockId(par2 + 1L, par3 + 1, par4) == Block.EntityThrowable.bO) {
            if (useFix) {
               tessellator.a(f * f2, f * f3, f * f4);
               tessellator.addVertexWithUVNoOffset(par2a + 1L - 0.015625, par3a, par4a + 1L, d1, d7);
               tessellator.addVertexWithUVNoOffset(par2a + 1L - 0.015625, par3a + 1.021875, par4a + 1L, d3, d7);
               tessellator.addVertexWithUVNoOffset(par2a + 1L - 0.015625, par3a + 1.021875, par4a, d3, d5);
               tessellator.addVertexWithUVNoOffset(par2a + 1L - 0.015625, par3a, par4a, d1, d5);
               tessellator.a(f, f, f);
               tessellator.addVertexWithUVNoOffset(par2a + 1L - 0.015625, par3a, par4a + 1L, d1, d7 + 0.0625);
               tessellator.addVertexWithUVNoOffset(par2a + 1L - 0.015625, par3a + 1.021875, par4a + 1L, d3, d7 + 0.0625);
               tessellator.addVertexWithUVNoOffset(par2a + 1L - 0.015625, par3a + 1.021875, par4a, d3, d5 + 0.0625);
               tessellator.addVertexWithUVNoOffset(par2a + 1L - 0.015625, par3a, par4a, d1, d5 + 0.0625);
            } else {
               tessellator.a(f * f2, f * f3, f * f4);
               tessellator.a(par2 + 1L - 0.015625, par3, par4 + 1L, d1, d7);
               tessellator.a(par2 + 1L - 0.015625, par3 + 1.021875, par4 + 1L, d3, d7);
               tessellator.a(par2 + 1L - 0.015625, par3 + 1.021875, par4, d3, d5);
               tessellator.a(par2 + 1L - 0.015625, par3, par4, d1, d5);
               tessellator.a(f, f, f);
               tessellator.a(par2 + 1L - 0.015625, par3, par4 + 1L, d1, d7 + 0.0625);
               tessellator.a(par2 + 1L - 0.015625, par3 + 1.021875, par4 + 1L, d3, d7 + 0.0625);
               tessellator.a(par2 + 1L - 0.015625, par3 + 1.021875, par4, d3, d5 + 0.0625);
               tessellator.a(par2 + 1L - 0.015625, par3, par4, d1, d5 + 0.0625);
            }
         }

         if (this.a.isBlockNormalCube(par2, par3, par4 - 1L) && this.a.getBlockId(par2, par3 + 1, par4 - 1L) == Block.EntityThrowable.bO) {
            if (useFix) {
               tessellator.a(f * f2, f * f3, f * f4);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, par4a + 0.015625, d1, d7);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + 1.021875, par4a + 0.015625, d3, d7);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + 1.021875, par4a + 0.015625, d3, d5);
               tessellator.addVertexWithUVNoOffset(par2a, par3a, par4a + 0.015625, d1, d5);
               tessellator.a(f, f, f);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, par4a + 0.015625, d1, d7 + 0.0625);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + 1.021875, par4a + 0.015625, d3, d7 + 0.0625);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + 1.021875, par4a + 0.015625, d3, d5 + 0.0625);
               tessellator.addVertexWithUVNoOffset(par2a, par3a, par4a + 0.015625, d1, d5 + 0.0625);
            } else {
               tessellator.a(f * f2, f * f3, f * f4);
               tessellator.a(par2 + 1L, par3, par4 + 0.015625, d1, d7);
               tessellator.a(par2 + 1L, par3 + 1.021875, par4 + 0.015625, d3, d7);
               tessellator.a(par2, par3 + 1.021875, par4 + 0.015625, d3, d5);
               tessellator.a(par2, par3, par4 + 0.015625, d1, d5);
               tessellator.a(f, f, f);
               tessellator.a(par2 + 1L, par3, par4 + 0.015625, d1, d7 + 0.0625);
               tessellator.a(par2 + 1L, par3 + 1.021875, par4 + 0.015625, d3, d7 + 0.0625);
               tessellator.a(par2, par3 + 1.021875, par4 + 0.015625, d3, d5 + 0.0625);
               tessellator.a(par2, par3, par4 + 0.015625, d1, d5 + 0.0625);
            }
         }

         if (this.a.isBlockNormalCube(par2, par3, par4 + 1L) && this.a.getBlockId(par2, par3 + 1, par4 + 1L) == Block.EntityThrowable.bO) {
            if (useFix) {
               tessellator.a(f * f2, f * f3, f * f4);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + 1.021875, par4a + 1L - 0.015625, d3, d5);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, par4a + 1L - 0.015625, d1, d5);
               tessellator.addVertexWithUVNoOffset(par2a, par3a, par4a + 1L - 0.015625, d1, d7);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + 1.021875, par4a + 1L - 0.015625, d3, d7);
               tessellator.a(f, f, f);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + 1.021875, par4a + 1L - 0.015625, d3, d5 + 0.0625);
               tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, par4a + 1L - 0.015625, d1, d5 + 0.0625);
               tessellator.addVertexWithUVNoOffset(par2a, par3a, par4a + 1L - 0.015625, d1, d7 + 0.0625);
               tessellator.addVertexWithUVNoOffset(par2a, par3a + 1.021875, par4a + 1L - 0.015625, d3, d7 + 0.0625);
            } else {
               tessellator.a(f * f2, f * f3, f * f4);
               tessellator.a(par2 + 1L, par3 + 1.021875, par4 + 1L - 0.015625, d3, d5);
               tessellator.a(par2 + 1L, par3, par4 + 1L - 0.015625, d1, d5);
               tessellator.a(par2, par3, par4 + 1L - 0.015625, d1, d7);
               tessellator.a(par2, par3 + 1.021875, par4 + 1L - 0.015625, d3, d7);
               tessellator.a(f, f, f);
               tessellator.a(par2 + 1L, par3 + 1.021875, par4 + 1L - 0.015625, d3, d5 + 0.0625);
               tessellator.a(par2 + 1L, par3, par4 + 1L - 0.015625, d1, d5 + 0.0625);
               tessellator.a(par2, par3, par4 + 1L - 0.015625, d1, d7 + 0.0625);
               tessellator.a(par2, par3 + 1.021875, par4 + 1L - 0.015625, d3, d7 + 0.0625);
            }
         }
      }

      return true;
   }

   public boolean renderBlockMinecartTrack(BlockRail par1BlockRail, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      Tessellator tessellator = Tessellator.a;
      int i = this.a.getBlockMetadata(par2, par3, par4);
      int j = par1BlockRail.a(0, i);
      if (this.d >= 0) {
         j = this.d;
      }

      if (par1BlockRail.v()) {
         i &= 7;
      }

      tessellator.b(par1BlockRail.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      tessellator.a(1.0F, 1.0F, 1.0F);
      int k = (j & 15) << 4;
      int l = j & 240;
      double d = k / 256.0F;
      double d1 = (k + 15.99F) / 256.0F;
      double d2 = l / 256.0F;
      double d3 = (l + 15.99F) / 256.0F;
      double d4 = 0.0625;
      if (useFix) {
         long d5 = par2a + 1L;
         long d6 = par2a + 1L;
         long d7 = par2a;
         long d8 = par2a;
         long d9 = par4a;
         long d10 = par4a + 1L;
         long d11 = par4a + 1L;
         long d12 = par4a;
         double d13 = par3a + d4;
         double d14 = par3a + d4;
         double d15 = par3a + d4;
         double d16 = par3a + d4;
         if (i == 1 || i == 2 || i == 3 || i == 7) {
            d5 = d8 = par2a + 1L;
            d6 = d7 = par2a + 0L;
            d9 = d10 = par4a + 1L;
            d11 = d12 = par4a + 0L;
         } else if (i == 8) {
            d5 = d6 = par2a + 0L;
            d7 = d8 = par2a + 1L;
            d9 = d12 = par4a + 1L;
            d10 = d11 = par4a + 0L;
         } else if (i == 9) {
            d5 = d8 = par2a + 0L;
            d6 = d7 = par2a + 1L;
            d9 = d10 = par4a + 0L;
            d11 = d12 = par4a + 1L;
         }

         if (i == 2 || i == 4) {
            d13++;
            d16++;
         } else if (i == 3 || i == 5) {
            d14++;
            d15++;
         }

         tessellator.addVertexWithUVNoOffset(d5, d13, d9, d1, d2);
         tessellator.addVertexWithUVNoOffset(d6, d14, d10, d1, d3);
         tessellator.addVertexWithUVNoOffset(d7, d15, d11, d, d3);
         tessellator.addVertexWithUVNoOffset(d8, d16, d12, d, d2);
         tessellator.addVertexWithUVNoOffset(d8, d16, d12, d, d2);
         tessellator.addVertexWithUVNoOffset(d7, d15, d11, d, d3);
         tessellator.addVertexWithUVNoOffset(d6, d14, d10, d1, d3);
         tessellator.addVertexWithUVNoOffset(d5, d13, d9, d1, d2);
      } else {
         long d5 = par2 + 1L;
         long d6 = par2 + 1L;
         long d7 = par2;
         long d8 = par2;
         long d9 = par4;
         long d10 = par4 + 1L;
         long d11 = par4 + 1L;
         long d12 = par4;
         double d13 = par3 + d4;
         double d14 = par3 + d4;
         double d15 = par3 + d4;
         double d16 = par3 + d4;
         if (i == 1 || i == 2 || i == 3 || i == 7) {
            d5 = d8 = par2 + 1L;
            d6 = d7 = par2 + 0L;
            d9 = d10 = par4 + 1L;
            d11 = d12 = par4 + 0L;
         } else if (i == 8) {
            d5 = d6 = par2 + 0L;
            d7 = d8 = par2 + 1L;
            d9 = d12 = par4 + 1L;
            d10 = d11 = par4 + 0L;
         } else if (i == 9) {
            d5 = d8 = par2 + 0L;
            d6 = d7 = par2 + 1L;
            d9 = d10 = par4 + 0L;
            d11 = d12 = par4 + 1L;
         }

         if (i == 2 || i == 4) {
            d13++;
            d16++;
         } else if (i == 3 || i == 5) {
            d14++;
            d15++;
         }

         tessellator.a(d5, d13, d9, d1, d2);
         tessellator.a(d6, d14, d10, d1, d3);
         tessellator.a(d7, d15, d11, d, d3);
         tessellator.a(d8, d16, d12, d, d2);
         tessellator.a(d8, d16, d12, d, d2);
         tessellator.a(d7, d15, d11, d, d3);
         tessellator.a(d6, d14, d10, d1, d3);
         tessellator.a(d5, d13, d9, d1, d2);
      }

      return true;
   }

   public boolean renderBlockLadder(Block par1Block, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.a_(0);
      if (this.d >= 0) {
         i = this.d;
      }

      tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      float f = 1.0F;
      tessellator.a(f, f, f);
      f = (i & 15) << 4;
      int j = i & 240;
      double d = f / 256.0F;
      double d1 = (f + 15.99F) / 256.0F;
      double d2 = j / 256.0F;
      double d3 = (j + 15.99F) / 256.0F;
      int k = this.a.getBlockMetadata(par2, par3, par4);
      double d5 = 0.05F;
      if (useFix) {
         if (k == 5) {
            tessellator.addVertexWithUVNoOffset(par2a + d5, par3a + 1, par4a + 1L, d, d2);
            tessellator.addVertexWithUVNoOffset(par2a + d5, par3a, par4a + 1L, d, d3);
            tessellator.addVertexWithUVNoOffset(par2a + d5, par3a, par4a, d1, d3);
            tessellator.addVertexWithUVNoOffset(par2a + d5, par3a + 1, par4a, d1, d2);
         }

         if (k == 4) {
            tessellator.addVertexWithUVNoOffset(par2a + 1L - d5, par3a, par4a + 1L, d1, d3);
            tessellator.addVertexWithUVNoOffset(par2a + 1L - d5, par3a + 1, par4a + 1L, d1, d2);
            tessellator.addVertexWithUVNoOffset(par2a + 1L - d5, par3a + 1, par4a, d, d2);
            tessellator.addVertexWithUVNoOffset(par2a + 1L - d5, par3a, par4a, d, d3);
         }

         if (k == 3) {
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, par4a + d5, d1, d3);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + 1, par4a + d5, d1, d2);
            tessellator.addVertexWithUVNoOffset(par2a, par3a + 1, par4a + d5, d, d2);
            tessellator.addVertexWithUVNoOffset(par2a, par3a, par4a + d5, d, d3);
         }

         if (k == 2) {
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + 1, par4a + 1L - d5, d, d2);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, par4a + 1L - d5, d, d3);
            tessellator.addVertexWithUVNoOffset(par2a, par3a, par4a + 1L - d5, d1, d3);
            tessellator.addVertexWithUVNoOffset(par2a, par3a + 1, par4a + 1L - d5, d1, d2);
         }
      } else {
         if (k == 5) {
            tessellator.a(par2 + d5, par3 + 1, par4 + 1L, d, d2);
            tessellator.a(par2 + d5, par3, par4 + 1L, d, d3);
            tessellator.a(par2 + d5, par3, par4, d1, d3);
            tessellator.a(par2 + d5, par3 + 1, par4, d1, d2);
         }

         if (k == 4) {
            tessellator.a(par2 + 1L - d5, par3, par4 + 1L, d1, d3);
            tessellator.a(par2 + 1L - d5, par3 + 1, par4 + 1L, d1, d2);
            tessellator.a(par2 + 1L - d5, par3 + 1, par4, d, d2);
            tessellator.a(par2 + 1L - d5, par3, par4, d, d3);
         }

         if (k == 3) {
            tessellator.a(par2 + 1L, par3, par4 + d5, d1, d3);
            tessellator.a(par2 + 1L, par3 + 1, par4 + d5, d1, d2);
            tessellator.a(par2, par3 + 1, par4 + d5, d, d2);
            tessellator.a(par2, par3, par4 + d5, d, d3);
         }

         if (k == 2) {
            tessellator.a(par2 + 1L, par3 + 1, par4 + 1L - d5, d, d2);
            tessellator.a(par2 + 1L, par3, par4 + 1L - d5, d, d3);
            tessellator.a(par2, par3, par4 + 1L - d5, d1, d3);
            tessellator.a(par2, par3 + 1, par4 + 1L - d5, d1, d2);
         }
      }

      return true;
   }

   public boolean renderBlockVine(Block par1Block, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.a_(0);
      if (this.d >= 0) {
         i = this.d;
      }

      float f = 1.0F;
      tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      int j = par1Block.colorMultiplier(this.a, par2, par3, par4);
      float f1 = (j >> 16 & 0xFF) / 255.0F;
      float d = (j >> 8 & 0xFF) / 255.0F;
      float f2 = (j & 0xFF) / 255.0F;
      tessellator.a(f * f1, f * d, f * f2);
      j = (i & 15) << 4;
      f1 = i & 240;
      d = j / 256.0F;
      double d1 = (j + 15.99F) / 256.0F;
      double d2 = f1 / 256.0F;
      double d3 = (f1 + 15.99F) / 256.0F;
      double d4 = 0.05F;
      int k = this.a.getBlockMetadata(par2, par3, par4);
      if ((k & 2) != 0) {
         if (useFix) {
            tessellator.addVertexWithUVNoOffset(par2a + d4, par3a + 1, par4a + 1L, d, d2);
            tessellator.addVertexWithUVNoOffset(par2a + d4, par3a, par4a + 1L, d, d3);
            tessellator.addVertexWithUVNoOffset(par2a + d4, par3a, par4a, d1, d3);
            tessellator.addVertexWithUVNoOffset(par2a + d4, par3a + 1, par4a, d1, d2);
            tessellator.addVertexWithUVNoOffset(par2a + d4, par3a + 1, par4a, d1, d2);
            tessellator.addVertexWithUVNoOffset(par2a + d4, par3a, par4a, d1, d3);
            tessellator.addVertexWithUVNoOffset(par2a + d4, par3a, par4a + 1L, d, d3);
            tessellator.addVertexWithUVNoOffset(par2a + d4, par3a + 1, par4a + 1L, d, d2);
         } else {
            tessellator.a(par2 + d4, par3 + 1, par4 + 1L, d, d2);
            tessellator.a(par2 + d4, par3, par4 + 1L, d, d3);
            tessellator.a(par2 + d4, par3, par4, d1, d3);
            tessellator.a(par2 + d4, par3 + 1, par4, d1, d2);
            tessellator.a(par2 + d4, par3 + 1, par4, d1, d2);
            tessellator.a(par2 + d4, par3, par4, d1, d3);
            tessellator.a(par2 + d4, par3, par4 + 1L, d, d3);
            tessellator.a(par2 + d4, par3 + 1, par4 + 1L, d, d2);
         }
      }

      if ((k & 8) != 0) {
         if (useFix) {
            tessellator.addVertexWithUVNoOffset(par2a + 1L - d4, par3a, par4a + 1L, d1, d3);
            tessellator.addVertexWithUVNoOffset(par2a + 1L - d4, par3a + 1, par4a + 1L, d1, d2);
            tessellator.addVertexWithUVNoOffset(par2a + 1L - d4, par3a + 1, par4a, d, d2);
            tessellator.addVertexWithUVNoOffset(par2a + 1L - d4, par3a, par4a, d, d3);
            tessellator.addVertexWithUVNoOffset(par2a + 1L - d4, par3a, par4a, d, d3);
            tessellator.addVertexWithUVNoOffset(par2a + 1L - d4, par3a + 1, par4a, d, d2);
            tessellator.addVertexWithUVNoOffset(par2a + 1L - d4, par3a + 1, par4a + 1L, d1, d2);
            tessellator.addVertexWithUVNoOffset(par2a + 1L - d4, par3a, par4a + 1L, d1, d3);
         } else {
            tessellator.a(par2 + 1L - d4, par3, par4 + 1L, d1, d3);
            tessellator.a(par2 + 1L - d4, par3 + 1, par4 + 1L, d1, d2);
            tessellator.a(par2 + 1L - d4, par3 + 1, par4, d, d2);
            tessellator.a(par2 + 1L - d4, par3, par4, d, d3);
            tessellator.a(par2 + 1L - d4, par3, par4, d, d3);
            tessellator.a(par2 + 1L - d4, par3 + 1, par4, d, d2);
            tessellator.a(par2 + 1L - d4, par3 + 1, par4 + 1L, d1, d2);
            tessellator.a(par2 + 1L - d4, par3, par4 + 1L, d1, d3);
         }
      }

      if ((k & 4) != 0) {
         if (useFix) {
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, par4a + d4, d1, d3);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + 1, par4a + d4, d1, d2);
            tessellator.addVertexWithUVNoOffset(par2a, par3a + 1, par4a + d4, d, d2);
            tessellator.addVertexWithUVNoOffset(par2a, par3a, par4a + d4, d, d3);
            tessellator.addVertexWithUVNoOffset(par2a, par3a, par4a + d4, d, d3);
            tessellator.addVertexWithUVNoOffset(par2a, par3a + 1, par4a + d4, d, d2);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + 1, par4a + d4, d1, d2);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, par4a + d4, d1, d3);
         } else {
            tessellator.a(par2 + 1L, par3, par4 + d4, d1, d3);
            tessellator.a(par2 + 1L, par3 + 1, par4 + d4, d1, d2);
            tessellator.a(par2, par3 + 1, par4 + d4, d, d2);
            tessellator.a(par2, par3, par4 + d4, d, d3);
            tessellator.a(par2, par3, par4 + d4, d, d3);
            tessellator.a(par2, par3 + 1, par4 + d4, d, d2);
            tessellator.a(par2 + 1L, par3 + 1, par4 + d4, d1, d2);
            tessellator.a(par2 + 1L, par3, par4 + d4, d1, d3);
         }
      }

      if ((k & 1) != 0) {
         if (useFix) {
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + 1, par4a + 1L - d4, d, d2);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, par4a + 1L - d4, d, d3);
            tessellator.addVertexWithUVNoOffset(par2a, par3a, par4a + 1L - d4, d1, d3);
            tessellator.addVertexWithUVNoOffset(par2a, par3a + 1, par4a + 1L - d4, d1, d2);
            tessellator.addVertexWithUVNoOffset(par2a, par3a + 1, par4a + 1L - d4, d1, d2);
            tessellator.addVertexWithUVNoOffset(par2a, par3a, par4a + 1L - d4, d1, d3);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a, par4a + 1L - d4, d, d3);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + 1, par4a + 1L - d4, d, d2);
         } else {
            tessellator.a(par2 + 1L, par3 + 1, par4 + 1L - d4, d, d2);
            tessellator.a(par2 + 1L, par3, par4 + 1L - d4, d, d3);
            tessellator.a(par2, par3, par4 + 1L - d4, d1, d3);
            tessellator.a(par2, par3 + 1, par4 + 1L - d4, d1, d2);
            tessellator.a(par2, par3 + 1, par4 + 1L - d4, d1, d2);
            tessellator.a(par2, par3, par4 + 1L - d4, d1, d3);
            tessellator.a(par2 + 1L, par3, par4 + 1L - d4, d, d3);
            tessellator.a(par2 + 1L, par3 + 1, par4 + 1L - d4, d, d2);
         }
      }

      if (this.a.isBlockNormalCube(par2, par3 + 1, par4)) {
         if (useFix) {
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + 1 - d4, par4a, d, d2);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + 1 - d4, par4a + 1L, d, d3);
            tessellator.addVertexWithUVNoOffset(par2a, par3a + 1 - d4, par4a + 1L, d1, d3);
            tessellator.addVertexWithUVNoOffset(par2a, par3a + 1 - d4, par4a, d1, d2);
         } else {
            tessellator.a(par2 + 1L, par3 + 1 - d4, par4, d, d2);
            tessellator.a(par2 + 1L, par3 + 1 - d4, par4 + 1L, d, d3);
            tessellator.a(par2, par3 + 1 - d4, par4 + 1L, d1, d3);
            tessellator.a(par2, par3 + 1 - d4, par4, d1, d2);
         }
      }

      return true;
   }

   public boolean renderBlockPane(BlockPane par1BlockPane, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      int i = this.a.b();
      Tessellator tessellator = Tessellator.a;
      tessellator.b(par1BlockPane.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      float f = 1.0F;
      int j = par1BlockPane.colorMultiplier(this.a, par2, par3, par4);
      float f1 = (j >> 16 & 0xFF) / 255.0F;
      float f2 = (j >> 8 & 0xFF) / 255.0F;
      float f3 = (j & 0xFF) / 255.0F;
      if (EntityRenderer.a) {
         float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
         float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
         float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
         f1 = f4;
         f2 = f5;
         f3 = f6;
      }

      tessellator.a(f * f1, f * f2, f * f3);
      int k = 0;
      int l = 0;
      if (this.d >= 0) {
         k = this.d;
         l = this.d;
      } else {
         int i1 = this.a.getBlockMetadata(par2, par3, par4);
         k = par1BlockPane.a(0, i1);
         l = par1BlockPane.v();
      }

      int j1 = (k & 15) << 4;
      int k1 = k & 240;
      double d = j1 / 256.0F;
      double d1 = (j1 + 7.99F) / 256.0F;
      double d2 = (j1 + 15.99F) / 256.0F;
      double d3 = k1 / 256.0F;
      double d4 = (k1 + 15.99F) / 256.0F;
      int l1 = (l & 15) << 4;
      int i2 = l & 240;
      double d5 = (l1 + 7) / 256.0F;
      double d6 = (l1 + 8.99F) / 256.0F;
      double d7 = i2 / 256.0F;
      double d8 = (i2 + 8) / 256.0F;
      double d9 = (i2 + 15.99F) / 256.0F;
      double d10 = par2;
      double d11 = par2 + 0.5;
      double d12 = par2 + 1L;
      double d13 = par4;
      double d14 = par4 + 0.5;
      double d15 = par4 + 1L;
      double d16 = par2 + 0.4375;
      double d17 = par2 + 0.5625;
      double d18 = par4 + 0.4375;
      double d19 = par4 + 0.5625;
      if (useFix) {
         d10 = par2a;
         d11 = par2a + 0.5;
         d12 = par2a + 1L;
         d13 = par4a;
         d14 = par4a + 0.5;
         d15 = par4a + 1L;
         d16 = par2a + 0.4375;
         d17 = par2a + 0.5625;
         d18 = par4a + 0.4375;
         d19 = par4a + 0.5625;
      }

      boolean flag = par1BlockPane.e(this.a.getBlockId(par2, par3, par4 - 1L));
      boolean flag1 = par1BlockPane.e(this.a.getBlockId(par2, par3, par4 + 1L));
      boolean flag2 = par1BlockPane.e(this.a.getBlockId(par2 - 1L, par3, par4));
      boolean flag3 = par1BlockPane.e(this.a.getBlockId(par2 + 1L, par3, par4));
      boolean flag4 = par1BlockPane.shouldSideBeRendered(this.a, par2, par3 + 1, par4, 1);
      boolean flag5 = par1BlockPane.shouldSideBeRendered(this.a, par2, par3 - 1, par4, 0);
      if (useFix) {
         if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1)) {
            if (flag2 && !flag3) {
               tessellator.addVertexWithUVNoOffset(d10, par3a + 1, d14, d, d3);
               tessellator.addVertexWithUVNoOffset(d10, par3a + 0, d14, d, d4);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d14, d1, d4);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d14, d1, d3);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d14, d, d3);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d14, d, d4);
               tessellator.addVertexWithUVNoOffset(d10, par3a + 0, d14, d1, d4);
               tessellator.addVertexWithUVNoOffset(d10, par3a + 1, d14, d1, d3);
               if (!flag1 && !flag) {
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d19, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d19, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d18, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d18, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d18, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d18, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d19, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d19, d6, d7);
               }

               if (flag4 || par3 < i - 1 && this.a.isAirBlock(par2 - 1L, par3 + 1, par4)) {
                  tessellator.addVertexWithUVNoOffset(d10, par3a + 1 + 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d19, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d18, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d10, par3a + 1 + 0.01, d18, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d10, par3a + 1 + 0.01, d19, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d10, par3a + 1 + 0.01, d18, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d18, d5, d8);
               }

               if (flag5 || par3 > 1 && this.a.isAirBlock(par2 - 1L, par3 - 1, par4)) {
                  tessellator.addVertexWithUVNoOffset(d10, par3a - 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d19, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d18, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d10, par3a - 0.01, d18, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d10, par3a - 0.01, d19, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d10, par3a - 0.01, d18, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d18, d5, d8);
               }
            } else if (!flag2 && flag3) {
               tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d14, d1, d3);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d14, d1, d4);
               tessellator.addVertexWithUVNoOffset(d12, par3a + 0, d14, d2, d4);
               tessellator.addVertexWithUVNoOffset(d12, par3a + 1, d14, d2, d3);
               tessellator.addVertexWithUVNoOffset(d12, par3a + 1, d14, d1, d3);
               tessellator.addVertexWithUVNoOffset(d12, par3a + 0, d14, d1, d4);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d14, d2, d4);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d14, d2, d3);
               if (!flag1 && !flag) {
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d18, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d18, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d19, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d19, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d19, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d19, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d18, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d18, d6, d7);
               }

               if (flag4 || par3 < i - 1 && this.a.isAirBlock(par2 + 1L, par3 + 1, par4)) {
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d19, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d12, par3a + 1 + 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d12, par3a + 1 + 0.01, d18, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d18, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d12, par3a + 1 + 0.01, d19, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d18, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d12, par3a + 1 + 0.01, d18, d5, d7);
               }

               if (flag5 || par3 > 1 && this.a.isAirBlock(par2 + 1L, par3 - 1, par4)) {
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d19, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d12, par3a - 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d12, par3a - 0.01, d18, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d18, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d12, par3a - 0.01, d19, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d18, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d12, par3a - 0.01, d18, d5, d7);
               }
            }
         } else {
            tessellator.addVertexWithUVNoOffset(d10, par3a + 1, d14, d, d3);
            tessellator.addVertexWithUVNoOffset(d10, par3a + 0, d14, d, d4);
            tessellator.addVertexWithUVNoOffset(d12, par3a + 0, d14, d2, d4);
            tessellator.addVertexWithUVNoOffset(d12, par3a + 1, d14, d2, d3);
            tessellator.addVertexWithUVNoOffset(d12, par3a + 1, d14, d, d3);
            tessellator.addVertexWithUVNoOffset(d12, par3a + 0, d14, d, d4);
            tessellator.addVertexWithUVNoOffset(d10, par3a + 0, d14, d2, d4);
            tessellator.addVertexWithUVNoOffset(d10, par3a + 1, d14, d2, d3);
            if (flag4) {
               tessellator.addVertexWithUVNoOffset(d10, par3a + 1 + 0.01, d19, d6, d9);
               tessellator.addVertexWithUVNoOffset(d12, par3a + 1 + 0.01, d19, d6, d7);
               tessellator.addVertexWithUVNoOffset(d12, par3a + 1 + 0.01, d18, d5, d7);
               tessellator.addVertexWithUVNoOffset(d10, par3a + 1 + 0.01, d18, d5, d9);
               tessellator.addVertexWithUVNoOffset(d12, par3a + 1 + 0.01, d19, d6, d9);
               tessellator.addVertexWithUVNoOffset(d10, par3a + 1 + 0.01, d19, d6, d7);
               tessellator.addVertexWithUVNoOffset(d10, par3a + 1 + 0.01, d18, d5, d7);
               tessellator.addVertexWithUVNoOffset(d12, par3a + 1 + 0.01, d18, d5, d9);
            } else {
               if (par3 < i - 1 && this.a.isAirBlock(par2 - 1L, par3 + 1, par4)) {
                  tessellator.addVertexWithUVNoOffset(d10, par3a + 1 + 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d19, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d18, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d10, par3a + 1 + 0.01, d18, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d10, par3a + 1 + 0.01, d19, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d10, par3a + 1 + 0.01, d18, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d18, d5, d8);
               }

               if (par3 < i - 1 && this.a.isAirBlock(par2 + 1L, par3 + 1, par4)) {
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d19, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d12, par3a + 1 + 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d12, par3a + 1 + 0.01, d18, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d18, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d12, par3a + 1 + 0.01, d19, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a + 1 + 0.01, d18, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d12, par3a + 1 + 0.01, d18, d5, d7);
               }
            }

            if (flag5) {
               tessellator.addVertexWithUVNoOffset(d10, par3a - 0.01, d19, d6, d9);
               tessellator.addVertexWithUVNoOffset(d12, par3a - 0.01, d19, d6, d7);
               tessellator.addVertexWithUVNoOffset(d12, par3a - 0.01, d18, d5, d7);
               tessellator.addVertexWithUVNoOffset(d10, par3a - 0.01, d18, d5, d9);
               tessellator.addVertexWithUVNoOffset(d12, par3a - 0.01, d19, d6, d9);
               tessellator.addVertexWithUVNoOffset(d10, par3a - 0.01, d19, d6, d7);
               tessellator.addVertexWithUVNoOffset(d10, par3a - 0.01, d18, d5, d7);
               tessellator.addVertexWithUVNoOffset(d12, par3a - 0.01, d18, d5, d9);
            } else {
               if (par3 > 1 && this.a.isAirBlock(par2 - 1L, par3 - 1, par4)) {
                  tessellator.addVertexWithUVNoOffset(d10, par3a - 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d19, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d18, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d10, par3a - 0.01, d18, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d10, par3a - 0.01, d19, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d10, par3a - 0.01, d18, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d18, d5, d8);
               }

               if (par3 > 1 && this.a.isAirBlock(par2 + 1L, par3 - 1, par4)) {
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d19, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d12, par3a - 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d12, par3a - 0.01, d18, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d18, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d12, par3a - 0.01, d19, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d19, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d11, par3a - 0.01, d18, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d12, par3a - 0.01, d18, d5, d7);
               }
            }
         }

         if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1)) {
            if (flag && !flag1) {
               tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d13, d, d3);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d13, d, d4);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d14, d1, d4);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d14, d1, d3);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d14, d, d3);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d14, d, d4);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d13, d1, d4);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d13, d1, d3);
               if (!flag3 && !flag2) {
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d14, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 0, d14, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 0, d14, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d14, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d14, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 0, d14, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 0, d14, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d14, d6, d7);
               }

               if (flag4 || par3 < i - 1 && this.a.isAirBlock(par2, par3 + 1, par4 - 1L)) {
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d13, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d14, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d14, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d13, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d14, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d13, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d13, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d14, d5, d7);
               }

               if (flag5 || par3 > 1 && this.a.isAirBlock(par2, par3 - 1, par4 - 1L)) {
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d13, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d14, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d14, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d13, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d14, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d13, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d13, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d14, d5, d7);
               }
            } else if (!flag && flag1) {
               tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d14, d1, d3);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d14, d1, d4);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d15, d2, d4);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d15, d2, d3);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d15, d1, d3);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d15, d1, d4);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d14, d2, d4);
               tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d14, d2, d3);
               if (!flag3 && !flag2) {
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d14, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 0, d14, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 0, d14, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d14, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d14, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 0, d14, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 0, d14, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d14, d6, d7);
               }

               if (flag4 || par3 < i - 1 && this.a.isAirBlock(par2, par3 + 1, par4 + 1L)) {
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d14, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d15, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d15, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d14, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d15, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d14, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d14, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d15, d6, d8);
               }

               if (flag5 || par3 > 1 && this.a.isAirBlock(par2, par3 - 1, par4 + 1L)) {
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d14, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d15, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d15, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d14, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d15, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d14, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d14, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d15, d6, d8);
               }
            }
         } else {
            tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d15, d, d3);
            tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d15, d, d4);
            tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d13, d2, d4);
            tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d13, d2, d3);
            tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d13, d, d3);
            tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d13, d, d4);
            tessellator.addVertexWithUVNoOffset(d11, par3a + 0, d15, d2, d4);
            tessellator.addVertexWithUVNoOffset(d11, par3a + 1, d15, d2, d3);
            if (flag4) {
               tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d15, d6, d9);
               tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d13, d6, d7);
               tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d13, d5, d7);
               tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d15, d5, d9);
               tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d13, d6, d9);
               tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d15, d6, d7);
               tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d15, d5, d7);
               tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d13, d5, d9);
            } else {
               if (par3 < i - 1 && this.a.isAirBlock(par2, par3 + 1, par4 - 1L)) {
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d13, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d14, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d14, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d13, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d14, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d13, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d13, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d14, d5, d7);
               }

               if (par3 < i - 1 && this.a.isAirBlock(par2, par3 + 1, par4 + 1L)) {
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d14, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d15, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d15, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d14, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d15, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d16, par3a + 1, d14, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d14, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a + 1, d15, d6, d8);
               }
            }

            if (flag5) {
               tessellator.addVertexWithUVNoOffset(d17, par3a, d15, d6, d9);
               tessellator.addVertexWithUVNoOffset(d17, par3a, d13, d6, d7);
               tessellator.addVertexWithUVNoOffset(d16, par3a, d13, d5, d7);
               tessellator.addVertexWithUVNoOffset(d16, par3a, d15, d5, d9);
               tessellator.addVertexWithUVNoOffset(d17, par3a, d13, d6, d9);
               tessellator.addVertexWithUVNoOffset(d17, par3a, d15, d6, d7);
               tessellator.addVertexWithUVNoOffset(d16, par3a, d15, d5, d7);
               tessellator.addVertexWithUVNoOffset(d16, par3a, d13, d5, d9);
            } else {
               if (par3 > 1 && this.a.isAirBlock(par2, par3 - 1, par4 - 1L)) {
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d13, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d14, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d14, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d13, d5, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d14, d6, d7);
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d13, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d13, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d14, d5, d7);
               }

               if (par3 > 1 && this.a.isAirBlock(par2, par3 - 1, par4 + 1L)) {
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d14, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d15, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d15, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d14, d6, d8);
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d15, d5, d8);
                  tessellator.addVertexWithUVNoOffset(d16, par3a, d14, d5, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d14, d6, d9);
                  tessellator.addVertexWithUVNoOffset(d17, par3a, d15, d6, d8);
               }
            }
         }

         return true;
      } else {
         if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1)) {
            if (flag2 && !flag3) {
               tessellator.a(d10, par3 + 1, d14, d, d3);
               tessellator.a(d10, par3 + 0, d14, d, d4);
               tessellator.a(d11, par3 + 0, d14, d1, d4);
               tessellator.a(d11, par3 + 1, d14, d1, d3);
               tessellator.a(d11, par3 + 1, d14, d, d3);
               tessellator.a(d11, par3 + 0, d14, d, d4);
               tessellator.a(d10, par3 + 0, d14, d1, d4);
               tessellator.a(d10, par3 + 1, d14, d1, d3);
               if (!flag1 && !flag) {
                  tessellator.a(d11, par3 + 1, d19, d5, d7);
                  tessellator.a(d11, par3 + 0, d19, d5, d9);
                  tessellator.a(d11, par3 + 0, d18, d6, d9);
                  tessellator.a(d11, par3 + 1, d18, d6, d7);
                  tessellator.a(d11, par3 + 1, d18, d5, d7);
                  tessellator.a(d11, par3 + 0, d18, d5, d9);
                  tessellator.a(d11, par3 + 0, d19, d6, d9);
                  tessellator.a(d11, par3 + 1, d19, d6, d7);
               }

               if (flag4 || par3 < i - 1 && this.a.isAirBlock(par2 - 1L, par3 + 1, par4)) {
                  tessellator.a(d10, par3 + 1 + 0.01, d19, d6, d8);
                  tessellator.a(d11, par3 + 1 + 0.01, d19, d6, d9);
                  tessellator.a(d11, par3 + 1 + 0.01, d18, d5, d9);
                  tessellator.a(d10, par3 + 1 + 0.01, d18, d5, d8);
                  tessellator.a(d11, par3 + 1 + 0.01, d19, d6, d8);
                  tessellator.a(d10, par3 + 1 + 0.01, d19, d6, d9);
                  tessellator.a(d10, par3 + 1 + 0.01, d18, d5, d9);
                  tessellator.a(d11, par3 + 1 + 0.01, d18, d5, d8);
               }

               if (flag5 || par3 > 1 && this.a.isAirBlock(par2 - 1L, par3 - 1, par4)) {
                  tessellator.a(d10, par3 - 0.01, d19, d6, d8);
                  tessellator.a(d11, par3 - 0.01, d19, d6, d9);
                  tessellator.a(d11, par3 - 0.01, d18, d5, d9);
                  tessellator.a(d10, par3 - 0.01, d18, d5, d8);
                  tessellator.a(d11, par3 - 0.01, d19, d6, d8);
                  tessellator.a(d10, par3 - 0.01, d19, d6, d9);
                  tessellator.a(d10, par3 - 0.01, d18, d5, d9);
                  tessellator.a(d11, par3 - 0.01, d18, d5, d8);
               }
            } else if (!flag2 && flag3) {
               tessellator.a(d11, par3 + 1, d14, d1, d3);
               tessellator.a(d11, par3 + 0, d14, d1, d4);
               tessellator.a(d12, par3 + 0, d14, d2, d4);
               tessellator.a(d12, par3 + 1, d14, d2, d3);
               tessellator.a(d12, par3 + 1, d14, d1, d3);
               tessellator.a(d12, par3 + 0, d14, d1, d4);
               tessellator.a(d11, par3 + 0, d14, d2, d4);
               tessellator.a(d11, par3 + 1, d14, d2, d3);
               if (!flag1 && !flag) {
                  tessellator.a(d11, par3 + 1, d18, d5, d7);
                  tessellator.a(d11, par3 + 0, d18, d5, d9);
                  tessellator.a(d11, par3 + 0, d19, d6, d9);
                  tessellator.a(d11, par3 + 1, d19, d6, d7);
                  tessellator.a(d11, par3 + 1, d19, d5, d7);
                  tessellator.a(d11, par3 + 0, d19, d5, d9);
                  tessellator.a(d11, par3 + 0, d18, d6, d9);
                  tessellator.a(d11, par3 + 1, d18, d6, d7);
               }

               if (flag4 || par3 < i - 1 && this.a.isAirBlock(par2 + 1L, par3 + 1, par4)) {
                  tessellator.a(d11, par3 + 1 + 0.01, d19, d6, d7);
                  tessellator.a(d12, par3 + 1 + 0.01, d19, d6, d8);
                  tessellator.a(d12, par3 + 1 + 0.01, d18, d5, d8);
                  tessellator.a(d11, par3 + 1 + 0.01, d18, d5, d7);
                  tessellator.a(d12, par3 + 1 + 0.01, d19, d6, d7);
                  tessellator.a(d11, par3 + 1 + 0.01, d19, d6, d8);
                  tessellator.a(d11, par3 + 1 + 0.01, d18, d5, d8);
                  tessellator.a(d12, par3 + 1 + 0.01, d18, d5, d7);
               }

               if (flag5 || par3 > 1 && this.a.isAirBlock(par2 + 1L, par3 - 1, par4)) {
                  tessellator.a(d11, par3 - 0.01, d19, d6, d7);
                  tessellator.a(d12, par3 - 0.01, d19, d6, d8);
                  tessellator.a(d12, par3 - 0.01, d18, d5, d8);
                  tessellator.a(d11, par3 - 0.01, d18, d5, d7);
                  tessellator.a(d12, par3 - 0.01, d19, d6, d7);
                  tessellator.a(d11, par3 - 0.01, d19, d6, d8);
                  tessellator.a(d11, par3 - 0.01, d18, d5, d8);
                  tessellator.a(d12, par3 - 0.01, d18, d5, d7);
               }
            }
         } else {
            tessellator.a(d10, par3 + 1, d14, d, d3);
            tessellator.a(d10, par3 + 0, d14, d, d4);
            tessellator.a(d12, par3 + 0, d14, d2, d4);
            tessellator.a(d12, par3 + 1, d14, d2, d3);
            tessellator.a(d12, par3 + 1, d14, d, d3);
            tessellator.a(d12, par3 + 0, d14, d, d4);
            tessellator.a(d10, par3 + 0, d14, d2, d4);
            tessellator.a(d10, par3 + 1, d14, d2, d3);
            if (flag4) {
               tessellator.a(d10, par3 + 1 + 0.01, d19, d6, d9);
               tessellator.a(d12, par3 + 1 + 0.01, d19, d6, d7);
               tessellator.a(d12, par3 + 1 + 0.01, d18, d5, d7);
               tessellator.a(d10, par3 + 1 + 0.01, d18, d5, d9);
               tessellator.a(d12, par3 + 1 + 0.01, d19, d6, d9);
               tessellator.a(d10, par3 + 1 + 0.01, d19, d6, d7);
               tessellator.a(d10, par3 + 1 + 0.01, d18, d5, d7);
               tessellator.a(d12, par3 + 1 + 0.01, d18, d5, d9);
            } else {
               if (par3 < i - 1 && this.a.isAirBlock(par2 - 1L, par3 + 1, par4)) {
                  tessellator.a(d10, par3 + 1 + 0.01, d19, d6, d8);
                  tessellator.a(d11, par3 + 1 + 0.01, d19, d6, d9);
                  tessellator.a(d11, par3 + 1 + 0.01, d18, d5, d9);
                  tessellator.a(d10, par3 + 1 + 0.01, d18, d5, d8);
                  tessellator.a(d11, par3 + 1 + 0.01, d19, d6, d8);
                  tessellator.a(d10, par3 + 1 + 0.01, d19, d6, d9);
                  tessellator.a(d10, par3 + 1 + 0.01, d18, d5, d9);
                  tessellator.a(d11, par3 + 1 + 0.01, d18, d5, d8);
               }

               if (par3 < i - 1 && this.a.isAirBlock(par2 + 1L, par3 + 1, par4)) {
                  tessellator.a(d11, par3 + 1 + 0.01, d19, d6, d7);
                  tessellator.a(d12, par3 + 1 + 0.01, d19, d6, d8);
                  tessellator.a(d12, par3 + 1 + 0.01, d18, d5, d8);
                  tessellator.a(d11, par3 + 1 + 0.01, d18, d5, d7);
                  tessellator.a(d12, par3 + 1 + 0.01, d19, d6, d7);
                  tessellator.a(d11, par3 + 1 + 0.01, d19, d6, d8);
                  tessellator.a(d11, par3 + 1 + 0.01, d18, d5, d8);
                  tessellator.a(d12, par3 + 1 + 0.01, d18, d5, d7);
               }
            }

            if (flag5) {
               tessellator.a(d10, par3 - 0.01, d19, d6, d9);
               tessellator.a(d12, par3 - 0.01, d19, d6, d7);
               tessellator.a(d12, par3 - 0.01, d18, d5, d7);
               tessellator.a(d10, par3 - 0.01, d18, d5, d9);
               tessellator.a(d12, par3 - 0.01, d19, d6, d9);
               tessellator.a(d10, par3 - 0.01, d19, d6, d7);
               tessellator.a(d10, par3 - 0.01, d18, d5, d7);
               tessellator.a(d12, par3 - 0.01, d18, d5, d9);
            } else {
               if (par3 > 1 && this.a.isAirBlock(par2 - 1L, par3 - 1, par4)) {
                  tessellator.a(d10, par3 - 0.01, d19, d6, d8);
                  tessellator.a(d11, par3 - 0.01, d19, d6, d9);
                  tessellator.a(d11, par3 - 0.01, d18, d5, d9);
                  tessellator.a(d10, par3 - 0.01, d18, d5, d8);
                  tessellator.a(d11, par3 - 0.01, d19, d6, d8);
                  tessellator.a(d10, par3 - 0.01, d19, d6, d9);
                  tessellator.a(d10, par3 - 0.01, d18, d5, d9);
                  tessellator.a(d11, par3 - 0.01, d18, d5, d8);
               }

               if (par3 > 1 && this.a.isAirBlock(par2 + 1L, par3 - 1, par4)) {
                  tessellator.a(d11, par3 - 0.01, d19, d6, d7);
                  tessellator.a(d12, par3 - 0.01, d19, d6, d8);
                  tessellator.a(d12, par3 - 0.01, d18, d5, d8);
                  tessellator.a(d11, par3 - 0.01, d18, d5, d7);
                  tessellator.a(d12, par3 - 0.01, d19, d6, d7);
                  tessellator.a(d11, par3 - 0.01, d19, d6, d8);
                  tessellator.a(d11, par3 - 0.01, d18, d5, d8);
                  tessellator.a(d12, par3 - 0.01, d18, d5, d7);
               }
            }
         }

         if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1)) {
            if (flag && !flag1) {
               tessellator.a(d11, par3 + 1, d13, d, d3);
               tessellator.a(d11, par3 + 0, d13, d, d4);
               tessellator.a(d11, par3 + 0, d14, d1, d4);
               tessellator.a(d11, par3 + 1, d14, d1, d3);
               tessellator.a(d11, par3 + 1, d14, d, d3);
               tessellator.a(d11, par3 + 0, d14, d, d4);
               tessellator.a(d11, par3 + 0, d13, d1, d4);
               tessellator.a(d11, par3 + 1, d13, d1, d3);
               if (!flag3 && !flag2) {
                  tessellator.a(d16, par3 + 1, d14, d5, d7);
                  tessellator.a(d16, par3 + 0, d14, d5, d9);
                  tessellator.a(d17, par3 + 0, d14, d6, d9);
                  tessellator.a(d17, par3 + 1, d14, d6, d7);
                  tessellator.a(d17, par3 + 1, d14, d5, d7);
                  tessellator.a(d17, par3 + 0, d14, d5, d9);
                  tessellator.a(d16, par3 + 0, d14, d6, d9);
                  tessellator.a(d16, par3 + 1, d14, d6, d7);
               }

               if (flag4 || par3 < i - 1 && this.a.isAirBlock(par2, par3 + 1, par4 - 1L)) {
                  tessellator.a(d16, par3 + 1, d13, d6, d7);
                  tessellator.a(d16, par3 + 1, d14, d6, d8);
                  tessellator.a(d17, par3 + 1, d14, d5, d8);
                  tessellator.a(d17, par3 + 1, d13, d5, d7);
                  tessellator.a(d16, par3 + 1, d14, d6, d7);
                  tessellator.a(d16, par3 + 1, d13, d6, d8);
                  tessellator.a(d17, par3 + 1, d13, d5, d8);
                  tessellator.a(d17, par3 + 1, d14, d5, d7);
               }

               if (flag5 || par3 > 1 && this.a.isAirBlock(par2, par3 - 1, par4 - 1L)) {
                  tessellator.a(d16, par3, d13, d6, d7);
                  tessellator.a(d16, par3, d14, d6, d8);
                  tessellator.a(d17, par3, d14, d5, d8);
                  tessellator.a(d17, par3, d13, d5, d7);
                  tessellator.a(d16, par3, d14, d6, d7);
                  tessellator.a(d16, par3, d13, d6, d8);
                  tessellator.a(d17, par3, d13, d5, d8);
                  tessellator.a(d17, par3, d14, d5, d7);
               }
            } else if (!flag && flag1) {
               tessellator.a(d11, par3 + 1, d14, d1, d3);
               tessellator.a(d11, par3 + 0, d14, d1, d4);
               tessellator.a(d11, par3 + 0, d15, d2, d4);
               tessellator.a(d11, par3 + 1, d15, d2, d3);
               tessellator.a(d11, par3 + 1, d15, d1, d3);
               tessellator.a(d11, par3 + 0, d15, d1, d4);
               tessellator.a(d11, par3 + 0, d14, d2, d4);
               tessellator.a(d11, par3 + 1, d14, d2, d3);
               if (!flag3 && !flag2) {
                  tessellator.a(d17, par3 + 1, d14, d5, d7);
                  tessellator.a(d17, par3 + 0, d14, d5, d9);
                  tessellator.a(d16, par3 + 0, d14, d6, d9);
                  tessellator.a(d16, par3 + 1, d14, d6, d7);
                  tessellator.a(d16, par3 + 1, d14, d5, d7);
                  tessellator.a(d16, par3 + 0, d14, d5, d9);
                  tessellator.a(d17, par3 + 0, d14, d6, d9);
                  tessellator.a(d17, par3 + 1, d14, d6, d7);
               }

               if (flag4 || par3 < i - 1 && this.a.isAirBlock(par2, par3 + 1, par4 + 1L)) {
                  tessellator.a(d16, par3 + 1, d14, d5, d8);
                  tessellator.a(d16, par3 + 1, d15, d5, d9);
                  tessellator.a(d17, par3 + 1, d15, d6, d9);
                  tessellator.a(d17, par3 + 1, d14, d6, d8);
                  tessellator.a(d16, par3 + 1, d15, d5, d8);
                  tessellator.a(d16, par3 + 1, d14, d5, d9);
                  tessellator.a(d17, par3 + 1, d14, d6, d9);
                  tessellator.a(d17, par3 + 1, d15, d6, d8);
               }

               if (flag5 || par3 > 1 && this.a.isAirBlock(par2, par3 - 1, par4 + 1L)) {
                  tessellator.a(d16, par3, d14, d5, d8);
                  tessellator.a(d16, par3, d15, d5, d9);
                  tessellator.a(d17, par3, d15, d6, d9);
                  tessellator.a(d17, par3, d14, d6, d8);
                  tessellator.a(d16, par3, d15, d5, d8);
                  tessellator.a(d16, par3, d14, d5, d9);
                  tessellator.a(d17, par3, d14, d6, d9);
                  tessellator.a(d17, par3, d15, d6, d8);
               }
            }
         } else {
            tessellator.a(d11, par3 + 1, d15, d, d3);
            tessellator.a(d11, par3 + 0, d15, d, d4);
            tessellator.a(d11, par3 + 0, d13, d2, d4);
            tessellator.a(d11, par3 + 1, d13, d2, d3);
            tessellator.a(d11, par3 + 1, d13, d, d3);
            tessellator.a(d11, par3 + 0, d13, d, d4);
            tessellator.a(d11, par3 + 0, d15, d2, d4);
            tessellator.a(d11, par3 + 1, d15, d2, d3);
            if (flag4) {
               tessellator.a(d17, par3 + 1, d15, d6, d9);
               tessellator.a(d17, par3 + 1, d13, d6, d7);
               tessellator.a(d16, par3 + 1, d13, d5, d7);
               tessellator.a(d16, par3 + 1, d15, d5, d9);
               tessellator.a(d17, par3 + 1, d13, d6, d9);
               tessellator.a(d17, par3 + 1, d15, d6, d7);
               tessellator.a(d16, par3 + 1, d15, d5, d7);
               tessellator.a(d16, par3 + 1, d13, d5, d9);
            } else {
               if (par3 < i - 1 && this.a.isAirBlock(par2, par3 + 1, par4 - 1L)) {
                  tessellator.a(d16, par3 + 1, d13, d6, d7);
                  tessellator.a(d16, par3 + 1, d14, d6, d8);
                  tessellator.a(d17, par3 + 1, d14, d5, d8);
                  tessellator.a(d17, par3 + 1, d13, d5, d7);
                  tessellator.a(d16, par3 + 1, d14, d6, d7);
                  tessellator.a(d16, par3 + 1, d13, d6, d8);
                  tessellator.a(d17, par3 + 1, d13, d5, d8);
                  tessellator.a(d17, par3 + 1, d14, d5, d7);
               }

               if (par3 < i - 1 && this.a.isAirBlock(par2, par3 + 1, par4 + 1L)) {
                  tessellator.a(d16, par3 + 1, d14, d5, d8);
                  tessellator.a(d16, par3 + 1, d15, d5, d9);
                  tessellator.a(d17, par3 + 1, d15, d6, d9);
                  tessellator.a(d17, par3 + 1, d14, d6, d8);
                  tessellator.a(d16, par3 + 1, d15, d5, d8);
                  tessellator.a(d16, par3 + 1, d14, d5, d9);
                  tessellator.a(d17, par3 + 1, d14, d6, d9);
                  tessellator.a(d17, par3 + 1, d15, d6, d8);
               }
            }

            if (flag5) {
               tessellator.a(d17, par3, d15, d6, d9);
               tessellator.a(d17, par3, d13, d6, d7);
               tessellator.a(d16, par3, d13, d5, d7);
               tessellator.a(d16, par3, d15, d5, d9);
               tessellator.a(d17, par3, d13, d6, d9);
               tessellator.a(d17, par3, d15, d6, d7);
               tessellator.a(d16, par3, d15, d5, d7);
               tessellator.a(d16, par3, d13, d5, d9);
            } else {
               if (par3 > 1 && this.a.isAirBlock(par2, par3 - 1, par4 - 1L)) {
                  tessellator.a(d16, par3, d13, d6, d7);
                  tessellator.a(d16, par3, d14, d6, d8);
                  tessellator.a(d17, par3, d14, d5, d8);
                  tessellator.a(d17, par3, d13, d5, d7);
                  tessellator.a(d16, par3, d14, d6, d7);
                  tessellator.a(d16, par3, d13, d6, d8);
                  tessellator.a(d17, par3, d13, d5, d8);
                  tessellator.a(d17, par3, d14, d5, d7);
               }

               if (par3 > 1 && this.a.isAirBlock(par2, par3 - 1, par4 + 1L)) {
                  tessellator.a(d16, par3, d14, d5, d8);
                  tessellator.a(d16, par3, d15, d5, d9);
                  tessellator.a(d17, par3, d15, d6, d9);
                  tessellator.a(d17, par3, d14, d6, d8);
                  tessellator.a(d16, par3, d15, d5, d8);
                  tessellator.a(d16, par3, d14, d5, d9);
                  tessellator.a(d17, par3, d14, d6, d9);
                  tessellator.a(d17, par3, d15, d6, d8);
               }
            }
         }

         return true;
      }
   }

   public boolean renderCrossedSquares(Block par1Block, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      Tessellator tessellator = Tessellator.a;
      tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      float f = 1.0F;
      int i = par1Block.colorMultiplier(this.a, par2, par3, par4);
      float f1 = (i >> 16 & 0xFF) / 255.0F;
      float f2 = (i >> 8 & 0xFF) / 255.0F;
      float f3 = (i & 0xFF) / 255.0F;
      if (EntityRenderer.a) {
         float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
         float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
         float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
         f1 = f4;
         f2 = f5;
         f3 = f6;
      }

      tessellator.a(f * f1, f * f2, f * f3);
      double d = par2;
      double d1 = par3;
      double d2 = par4;
      if (useFix) {
         d = par2a;
         d1 = par3a;
         d2 = par4a;
      }

      if (par1Block == Block.X) {
         long l = par2 * 3129871L ^ par4 * 116129781L ^ par3;
         l = l * l * 42317861L + l * 11L;
         d += ((float)(l >> 16 & 15L) / 15.0F - 0.5) * 0.5;
         d1 += ((float)(l >> 20 & 15L) / 15.0F - 1.0) * 0.2;
         d2 += ((float)(l >> 24 & 15L) / 15.0F - 0.5) * 0.5;
      }

      if (useFix) {
         this.drawCrossedSquaresNoOffset(par1Block, this.a.getBlockMetadata(par2, par3, par4), d, d1, d2);
      } else {
         this.a(par1Block, this.a.getBlockMetadata(par2, par3, par4), d, d1, d2);
      }

      return true;
   }

   public boolean renderBlockStem(Block par1Block, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      BlockStem blockstem = (BlockStem)par1Block;
      Tessellator tessellator = Tessellator.a;
      tessellator.b(blockstem.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      float f = 1.0F;
      int i = blockstem.colorMultiplier(this.a, par2, par3, par4);
      float f1 = (i >> 16 & 0xFF) / 255.0F;
      float f2 = (i >> 8 & 0xFF) / 255.0F;
      float f3 = (i & 0xFF) / 255.0F;
      if (EntityRenderer.a) {
         float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
         float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
         float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
         f1 = f4;
         f2 = f5;
         f3 = f6;
      }

      tessellator.a(f * f1, f * f2, f * f3);
      blockstem.setBlockBoundsBasedOnState(this.a, par2, par3, par4);
      int j = blockstem.func_35296_f(this.a, par2, par3, par4);
      if (useFix) {
         if (j < 0) {
            this.renderBlockStemSmallNoOffset(blockstem, this.a.getBlockMetadata(par2, par3, par4), blockstem.bZ, par2a, par3a - 0.0625, par4a);
         } else {
            this.renderBlockStemSmallNoOffset(blockstem, this.a.getBlockMetadata(par2, par3, par4), 0.5, par2a, par3a - 0.0625, par4a);
            this.renderBlockStemBigNoOffset(blockstem, this.a.getBlockMetadata(par2, par3, par4), j, blockstem.bZ, par2a, par3a - 0.0625, par4a);
         }
      } else if (j < 0) {
         this.a(blockstem, this.a.getBlockMetadata(par2, par3, par4), blockstem.bZ, par2, par3 - 0.0625, par4);
      } else {
         this.a(blockstem, this.a.getBlockMetadata(par2, par3, par4), 0.5, par2, par3 - 0.0625, par4);
         this.a(blockstem, this.a.getBlockMetadata(par2, par3, par4), j, blockstem.bZ, par2, par3 - 0.0625, par4);
      }

      return true;
   }

   public boolean renderBlockCrops(Block par1Block, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      double cropYOffset = -0.0625;
      if (par1Block.bO == 115) {
         cropYOffset = 0.0;
      }

      Tessellator tessellator = Tessellator.a;
      tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      tessellator.a(1.0F, 1.0F, 1.0F);
      if (useFix) {
         this.renderBlockCropsStripelands(par1Block, this.a.getBlockMetadata(par2, par3, par4), par2a, par3a + cropYOffset, par4a);
      } else {
         this.b(par1Block, this.a.getBlockMetadata(par2, par3, par4), par2, par3 + cropYOffset, par4);
      }

      return true;
   }

   public void a(Block par1Block, double par2, double par4, double par6, double par8, double par10) {
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.a_(0);
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      float f = j / 256.0F;
      float f1 = (j + 15.99F) / 256.0F;
      float f2 = k / 256.0F;
      float f3 = (k + 15.99F) / 256.0F;
      double d = f + 0.02734375;
      double d1 = f2 + 0.0234375;
      double d2 = f + 0.03515625;
      double d3 = f2 + 0.03125;
      double d4 = par2;
      double d5 = par2 + 1.0;
      double d6 = par6;
      double d7 = par6 + 1.0;
      par2 += 0.5;
      par6 += 0.5;
      double d8 = 0.0625;
      double d9 = 0.625;
      tessellator.a(par2 + (par8 * (1.0 - d9) - d8), par4 + d9, par6 + (par10 * (1.0 - d9) - d8), d, d1);
      tessellator.a(par2 + (par8 * (1.0 - d9) - d8), par4 + d9, par6 + (par10 * (1.0 - d9) + d8), d, d3);
      tessellator.a(par2 + (par8 * (1.0 - d9) + d8), par4 + d9, par6 + (par10 * (1.0 - d9) + d8), d2, d3);
      tessellator.a(par2 + (par8 * (1.0 - d9) + d8), par4 + d9, par6 + (par10 * (1.0 - d9) - d8), d2, d1);
      tessellator.a(par2 - d8, par4 + 1.0, d6, f, f2);
      tessellator.a(par2 - d8 + par8, par4 + 0.0, d6 + par10, f, f3);
      tessellator.a(par2 - d8 + par8, par4 + 0.0, d7 + par10, f1, f3);
      tessellator.a(par2 - d8, par4 + 1.0, d7, f1, f2);
      tessellator.a(par2 + d8, par4 + 1.0, d7, f, f2);
      tessellator.a(par2 + par8 + d8, par4 + 0.0, d7 + par10, f, f3);
      tessellator.a(par2 + par8 + d8, par4 + 0.0, d6 + par10, f1, f3);
      tessellator.a(par2 + d8, par4 + 1.0, d6, f1, f2);
      tessellator.a(d4, par4 + 1.0, par6 + d8, f, f2);
      tessellator.a(d4 + par8, par4 + 0.0, par6 + d8 + par10, f, f3);
      tessellator.a(d5 + par8, par4 + 0.0, par6 + d8 + par10, f1, f3);
      tessellator.a(d5, par4 + 1.0, par6 + d8, f1, f2);
      tessellator.a(d5, par4 + 1.0, par6 - d8, f, f2);
      tessellator.a(d5 + par8, par4 + 0.0, par6 - d8 + par10, f, f3);
      tessellator.a(d4 + par8, par4 + 0.0, par6 - d8 + par10, f1, f3);
      tessellator.a(d4, par4 + 1.0, par6 - d8, f1, f2);
   }

   public void renderTorchAtAngleNoOffset(Block par1Block, double par2, double par4, double par6, double par8, double par10) {
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.a_(0);
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      float f = j / 256.0F;
      float f1 = (j + 15.99F) / 256.0F;
      float f2 = k / 256.0F;
      float f3 = (k + 15.99F) / 256.0F;
      double d = f + 0.02734375;
      double d1 = f2 + 0.0234375;
      double d2 = f + 0.03515625;
      double d3 = f2 + 0.03125;
      double d4 = par2;
      double d5 = par2 + 1.0;
      double d6 = par6;
      double d7 = par6 + 1.0;
      par2 += 0.5;
      par6 += 0.5;
      double d8 = 0.0625;
      double d9 = 0.625;
      tessellator.addVertexWithUVNoOffset(par2 + (par8 * (1.0 - d9) - d8), par4 + d9, par6 + (par10 * (1.0 - d9) - d8), d, d1);
      tessellator.addVertexWithUVNoOffset(par2 + (par8 * (1.0 - d9) - d8), par4 + d9, par6 + (par10 * (1.0 - d9) + d8), d, d3);
      tessellator.addVertexWithUVNoOffset(par2 + (par8 * (1.0 - d9) + d8), par4 + d9, par6 + (par10 * (1.0 - d9) + d8), d2, d3);
      tessellator.addVertexWithUVNoOffset(par2 + (par8 * (1.0 - d9) + d8), par4 + d9, par6 + (par10 * (1.0 - d9) - d8), d2, d1);
      tessellator.addVertexWithUVNoOffset(par2 - d8, par4 + 1.0, d6, f, f2);
      tessellator.addVertexWithUVNoOffset(par2 - d8 + par8, par4 + 0.0, d6 + par10, f, f3);
      tessellator.addVertexWithUVNoOffset(par2 - d8 + par8, par4 + 0.0, d7 + par10, f1, f3);
      tessellator.addVertexWithUVNoOffset(par2 - d8, par4 + 1.0, d7, f1, f2);
      tessellator.addVertexWithUVNoOffset(par2 + d8, par4 + 1.0, d7, f, f2);
      tessellator.addVertexWithUVNoOffset(par2 + par8 + d8, par4 + 0.0, d7 + par10, f, f3);
      tessellator.addVertexWithUVNoOffset(par2 + par8 + d8, par4 + 0.0, d6 + par10, f1, f3);
      tessellator.addVertexWithUVNoOffset(par2 + d8, par4 + 1.0, d6, f1, f2);
      tessellator.addVertexWithUVNoOffset(d4, par4 + 1.0, par6 + d8, f, f2);
      tessellator.addVertexWithUVNoOffset(d4 + par8, par4 + 0.0, par6 + d8 + par10, f, f3);
      tessellator.addVertexWithUVNoOffset(d5 + par8, par4 + 0.0, par6 + d8 + par10, f1, f3);
      tessellator.addVertexWithUVNoOffset(d5, par4 + 1.0, par6 + d8, f1, f2);
      tessellator.addVertexWithUVNoOffset(d5, par4 + 1.0, par6 - d8, f, f2);
      tessellator.addVertexWithUVNoOffset(d5 + par8, par4 + 0.0, par6 - d8 + par10, f, f3);
      tessellator.addVertexWithUVNoOffset(d4 + par8, par4 + 0.0, par6 - d8 + par10, f1, f3);
      tessellator.addVertexWithUVNoOffset(d4, par4 + 1.0, par6 - d8, f1, f2);
   }

   public void a(Block par1Block, int par2, double par3, double par5, double par7) {
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.a(0, par2);
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      double d = j / 256.0F;
      double d1 = (j + 15.99F) / 256.0F;
      double d2 = k / 256.0F;
      double d3 = (k + 15.99F) / 256.0F;
      double d4 = par3 + 0.05;
      double d5 = par3 + 0.95;
      double d6 = par7 + 0.05;
      double d7 = par7 + 0.95;
      tessellator.a(d4, par5 + 1.0, d6, d, d2);
      tessellator.a(d4, par5 + 0.0, d6, d, d3);
      tessellator.a(d5, par5 + 0.0, d7, d1, d3);
      tessellator.a(d5, par5 + 1.0, d7, d1, d2);
      tessellator.a(d5, par5 + 1.0, d7, d, d2);
      tessellator.a(d5, par5 + 0.0, d7, d, d3);
      tessellator.a(d4, par5 + 0.0, d6, d1, d3);
      tessellator.a(d4, par5 + 1.0, d6, d1, d2);
      tessellator.a(d4, par5 + 1.0, d7, d, d2);
      tessellator.a(d4, par5 + 0.0, d7, d, d3);
      tessellator.a(d5, par5 + 0.0, d6, d1, d3);
      tessellator.a(d5, par5 + 1.0, d6, d1, d2);
      tessellator.a(d5, par5 + 1.0, d6, d, d2);
      tessellator.a(d5, par5 + 0.0, d6, d, d3);
      tessellator.a(d4, par5 + 0.0, d7, d1, d3);
      tessellator.a(d4, par5 + 1.0, d7, d1, d2);
   }

   public void drawCrossedSquaresNoOffset(Block par1Block, int par2, double par3, double par5, double par7) {
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.a(0, par2);
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      double d = j / 256.0F;
      double d1 = (j + 15.99F) / 256.0F;
      double d2 = k / 256.0F;
      double d3 = (k + 15.99F) / 256.0F;
      double d4 = par3 + 0.05;
      double d5 = par3 + 0.95;
      double d6 = par7 + 0.05;
      double d7 = par7 + 0.95;
      tessellator.addVertexWithUVNoOffset(d4, par5 + 1.0, d6, d, d2);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 0.0, d6, d, d3);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 0.0, d7, d1, d3);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 1.0, d7, d1, d2);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 1.0, d7, d, d2);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 0.0, d7, d, d3);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 0.0, d6, d1, d3);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 1.0, d6, d1, d2);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 1.0, d7, d, d2);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 0.0, d7, d, d3);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 0.0, d6, d1, d3);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 1.0, d6, d1, d2);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 1.0, d6, d, d2);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 0.0, d6, d, d3);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 0.0, d7, d1, d3);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 1.0, d7, d1, d2);
   }

   public void a(Block par1Block, int par2, double par3, double par5, double par7, double par9) {
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.a(0, par2);
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      double d = j / 256.0F;
      double d1 = (j + 15.99F) / 256.0F;
      double d2 = k / 256.0F;
      double d3 = (k + 15.99F * par3) / 256.0;
      double d4 = par5 + 0.05;
      double d5 = par5 + 0.95;
      double d6 = par9 + 0.05;
      double d7 = par9 + 0.95;
      tessellator.a(d4, par7 + par3, d6, d, d2);
      tessellator.a(d4, par7 + 0.0, d6, d, d3);
      tessellator.a(d5, par7 + 0.0, d7, d1, d3);
      tessellator.a(d5, par7 + par3, d7, d1, d2);
      tessellator.a(d5, par7 + par3, d7, d, d2);
      tessellator.a(d5, par7 + 0.0, d7, d, d3);
      tessellator.a(d4, par7 + 0.0, d6, d1, d3);
      tessellator.a(d4, par7 + par3, d6, d1, d2);
      tessellator.a(d4, par7 + par3, d7, d, d2);
      tessellator.a(d4, par7 + 0.0, d7, d, d3);
      tessellator.a(d5, par7 + 0.0, d6, d1, d3);
      tessellator.a(d5, par7 + par3, d6, d1, d2);
      tessellator.a(d5, par7 + par3, d6, d, d2);
      tessellator.a(d5, par7 + 0.0, d6, d, d3);
      tessellator.a(d4, par7 + 0.0, d7, d1, d3);
      tessellator.a(d4, par7 + par3, d7, d1, d2);
   }

   public void renderBlockStemSmallNoOffset(Block par1Block, int par2, double par3, double par5, double par7, double par9) {
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.a(0, par2);
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      double d = j / 256.0F;
      double d1 = (j + 15.99F) / 256.0F;
      double d2 = k / 256.0F;
      double d3 = (k + 15.99F * par3) / 256.0;
      double d4 = par5 + 0.05;
      double d5 = par5 + 0.95;
      double d6 = par9 + 0.05;
      double d7 = par9 + 0.95;
      tessellator.addVertexWithUVNoOffset(d4, par7 + par3, d6, d, d2);
      tessellator.addVertexWithUVNoOffset(d4, par7 + 0.0, d6, d, d3);
      tessellator.addVertexWithUVNoOffset(d5, par7 + 0.0, d7, d1, d3);
      tessellator.addVertexWithUVNoOffset(d5, par7 + par3, d7, d1, d2);
      tessellator.addVertexWithUVNoOffset(d5, par7 + par3, d7, d, d2);
      tessellator.addVertexWithUVNoOffset(d5, par7 + 0.0, d7, d, d3);
      tessellator.addVertexWithUVNoOffset(d4, par7 + 0.0, d6, d1, d3);
      tessellator.addVertexWithUVNoOffset(d4, par7 + par3, d6, d1, d2);
      tessellator.addVertexWithUVNoOffset(d4, par7 + par3, d7, d, d2);
      tessellator.addVertexWithUVNoOffset(d4, par7 + 0.0, d7, d, d3);
      tessellator.addVertexWithUVNoOffset(d5, par7 + 0.0, d6, d1, d3);
      tessellator.addVertexWithUVNoOffset(d5, par7 + par3, d6, d1, d2);
      tessellator.addVertexWithUVNoOffset(d5, par7 + par3, d6, d, d2);
      tessellator.addVertexWithUVNoOffset(d5, par7 + 0.0, d6, d, d3);
      tessellator.addVertexWithUVNoOffset(d4, par7 + 0.0, d7, d1, d3);
      tessellator.addVertexWithUVNoOffset(d4, par7 + par3, d7, d1, d2);
   }

   public boolean renderBlockLilyPad(Block par1Block, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.bN;
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      float f = 0.015625F;
      double d = j / 256.0F;
      double d1 = (j + 15.99F) / 256.0F;
      double d2 = k / 256.0F;
      double d3 = (k + 15.99F) / 256.0F;
      long l = par2 * 3129871L ^ par4 * 116129781L ^ par3;
      l = l * l * 42317861L + l * 11L;
      int i1 = (int)(l >> 16 & 3L);
      tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4));
      float f3 = (i1 & 1) * 0.5F * (1 - i1 / 2 % 2 * 2);
      float f4 = (i1 + 1 & 1) * 0.5F * (1 - (i1 + 1) / 2 % 2 * 2);
      if (useFix) {
         tessellator.c(par1Block.i());
         tessellator.addVertexWithUVNoOffset((double)par2a + (0.5F + f3 - f4), par3a + f, (double)par4a + (0.5F + f3 + f4), d, d2);
         tessellator.addVertexWithUVNoOffset((double)par2a + (0.5F + f3 + f4), par3a + f, (double)par4a + (0.5F - f3 + f4), d1, d2);
         tessellator.addVertexWithUVNoOffset((double)par2a + (0.5F - f3 + f4), par3a + f, (double)par4a + (0.5F - f3 - f4), d1, d3);
         tessellator.addVertexWithUVNoOffset((double)par2a + (0.5F - f3 - f4), par3a + f, (double)par4a + (0.5F + f3 - f4), d, d3);
         tessellator.c((par1Block.i() & 16711422) >> 1);
         tessellator.addVertexWithUVNoOffset((double)par2a + (0.5F - f3 - f4), par3a + f, (double)par4a + (0.5F + f3 - f4), d, d3);
         tessellator.addVertexWithUVNoOffset((double)par2a + (0.5F - f3 + f4), par3a + f, (double)par4a + (0.5F - f3 - f4), d1, d3);
         tessellator.addVertexWithUVNoOffset((double)par2a + (0.5F + f3 + f4), par3a + f, (double)par4a + (0.5F - f3 + f4), d1, d2);
         tessellator.addVertexWithUVNoOffset((double)par2a + (0.5F + f3 - f4), par3a + f, (double)par4a + (0.5F + f3 + f4), d, d2);
      } else {
         tessellator.c(par1Block.i());
         tessellator.a((double)par2 + (0.5F + f3 - f4), par3 + f, (double)par4 + (0.5F + f3 + f4), d, d2);
         tessellator.a((double)par2 + (0.5F + f3 + f4), par3 + f, (double)par4 + (0.5F - f3 + f4), d1, d2);
         tessellator.a((double)par2 + (0.5F - f3 + f4), par3 + f, (double)par4 + (0.5F - f3 - f4), d1, d3);
         tessellator.a((double)par2 + (0.5F - f3 - f4), par3 + f, (double)par4 + (0.5F + f3 - f4), d, d3);
         tessellator.c((par1Block.i() & 16711422) >> 1);
         tessellator.a((double)par2 + (0.5F - f3 - f4), par3 + f, (double)par4 + (0.5F + f3 - f4), d, d3);
         tessellator.a((double)par2 + (0.5F - f3 + f4), par3 + f, (double)par4 + (0.5F - f3 - f4), d1, d3);
         tessellator.a((double)par2 + (0.5F + f3 + f4), par3 + f, (double)par4 + (0.5F - f3 + f4), d1, d2);
         tessellator.a((double)par2 + (0.5F + f3 - f4), par3 + f, (double)par4 + (0.5F + f3 + f4), d, d2);
      }

      return true;
   }

   public void a(Block par1Block, int par2, int par3, double par4, double par6, double par8, double par10) {
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.a(0, par2) + 16;
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      double d = j / 256.0F;
      double d1 = (j + 15.99F) / 256.0F;
      double d2 = k / 256.0F;
      double d3 = (k + 15.99F * par4) / 256.0;
      double d4 = par6;
      double d5 = par6 + 1.0;
      double d6 = par10;
      double d7 = par10 + 1.0;
      double d8 = par6 + 0.5;
      double d9 = par10 + 0.5;
      if ((par3 + 1) / 2 % 2 == 1) {
         double d10 = d1;
         d1 = d;
         d = d10;
      }

      if (par3 < 2) {
         tessellator.a(d4, par8 + par4, d9, d, d2);
         tessellator.a(d4, par8 + 0.0, d9, d, d3);
         tessellator.a(d5, par8 + 0.0, d9, d1, d3);
         tessellator.a(d5, par8 + par4, d9, d1, d2);
         tessellator.a(d5, par8 + par4, d9, d1, d2);
         tessellator.a(d5, par8 + 0.0, d9, d1, d3);
         tessellator.a(d4, par8 + 0.0, d9, d, d3);
         tessellator.a(d4, par8 + par4, d9, d, d2);
      } else {
         tessellator.a(d8, par8 + par4, d7, d, d2);
         tessellator.a(d8, par8 + 0.0, d7, d, d3);
         tessellator.a(d8, par8 + 0.0, d6, d1, d3);
         tessellator.a(d8, par8 + par4, d6, d1, d2);
         tessellator.a(d8, par8 + par4, d6, d1, d2);
         tessellator.a(d8, par8 + 0.0, d6, d1, d3);
         tessellator.a(d8, par8 + 0.0, d7, d, d3);
         tessellator.a(d8, par8 + par4, d7, d, d2);
      }
   }

   public void renderBlockStemBigNoOffset(Block par1Block, int par2, int par3, double par4, double par6, double par8, double par10) {
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.a(0, par2) + 16;
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      double d = j / 256.0F;
      double d1 = (j + 15.99F) / 256.0F;
      double d2 = k / 256.0F;
      double d3 = (k + 15.99F * par4) / 256.0;
      double d4 = par6;
      double d5 = par6 + 1.0;
      double d6 = par10;
      double d7 = par10 + 1.0;
      double d8 = par6 + 0.5;
      double d9 = par10 + 0.5;
      if ((par3 + 1) / 2 % 2 == 1) {
         double d10 = d1;
         d1 = d;
         d = d10;
      }

      if (par3 < 2) {
         tessellator.addVertexWithUVNoOffset(d4, par8 + par4, d9, d, d2);
         tessellator.addVertexWithUVNoOffset(d4, par8 + 0.0, d9, d, d3);
         tessellator.addVertexWithUVNoOffset(d5, par8 + 0.0, d9, d1, d3);
         tessellator.addVertexWithUVNoOffset(d5, par8 + par4, d9, d1, d2);
         tessellator.addVertexWithUVNoOffset(d5, par8 + par4, d9, d1, d2);
         tessellator.addVertexWithUVNoOffset(d5, par8 + 0.0, d9, d1, d3);
         tessellator.addVertexWithUVNoOffset(d4, par8 + 0.0, d9, d, d3);
         tessellator.addVertexWithUVNoOffset(d4, par8 + par4, d9, d, d2);
      } else {
         tessellator.addVertexWithUVNoOffset(d8, par8 + par4, d7, d, d2);
         tessellator.addVertexWithUVNoOffset(d8, par8 + 0.0, d7, d, d3);
         tessellator.addVertexWithUVNoOffset(d8, par8 + 0.0, d6, d1, d3);
         tessellator.addVertexWithUVNoOffset(d8, par8 + par4, d6, d1, d2);
         tessellator.addVertexWithUVNoOffset(d8, par8 + par4, d6, d1, d2);
         tessellator.addVertexWithUVNoOffset(d8, par8 + 0.0, d6, d1, d3);
         tessellator.addVertexWithUVNoOffset(d8, par8 + 0.0, d7, d, d3);
         tessellator.addVertexWithUVNoOffset(d8, par8 + par4, d7, d, d2);
      }
   }

   public void b(Block par1Block, int par2, double par3, double par5, double par7) {
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.a(0, par2);
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      double d = j / 256.0F;
      double d1 = (j + 15.99F) / 256.0F;
      double d2 = k / 256.0F;
      double d3 = (k + 15.99F) / 256.0F;
      double d4 = par3 + 0.25;
      double d5 = par3 + 0.75;
      double d6 = par7;
      double d7 = par7 + 1.0;
      tessellator.a(d4, par5 + 1.0, d6, d, d2);
      tessellator.a(d4, par5 + 0.0, d6, d, d3);
      tessellator.a(d4, par5 + 0.0, d7, d1, d3);
      tessellator.a(d4, par5 + 1.0, d7, d1, d2);
      tessellator.a(d4, par5 + 1.0, d7, d, d2);
      tessellator.a(d4, par5 + 0.0, d7, d, d3);
      tessellator.a(d4, par5 + 0.0, d6, d1, d3);
      tessellator.a(d4, par5 + 1.0, d6, d1, d2);
      tessellator.a(d5, par5 + 1.0, d7, d, d2);
      tessellator.a(d5, par5 + 0.0, d7, d, d3);
      tessellator.a(d5, par5 + 0.0, d6, d1, d3);
      tessellator.a(d5, par5 + 1.0, d6, d1, d2);
      tessellator.a(d5, par5 + 1.0, d6, d, d2);
      tessellator.a(d5, par5 + 0.0, d6, d, d3);
      tessellator.a(d5, par5 + 0.0, d7, d1, d3);
      tessellator.a(d5, par5 + 1.0, d7, d1, d2);
      d4 = par3;
      d5 = par3 + 1.0;
      d6 = par7 + 0.25;
      d7 = par7 + 0.75;
      tessellator.a(d4, par5 + 1.0, d6, d, d2);
      tessellator.a(d4, par5 + 0.0, d6, d, d3);
      tessellator.a(d5, par5 + 0.0, d6, d1, d3);
      tessellator.a(d5, par5 + 1.0, d6, d1, d2);
      tessellator.a(d5, par5 + 1.0, d6, d, d2);
      tessellator.a(d5, par5 + 0.0, d6, d, d3);
      tessellator.a(d4, par5 + 0.0, d6, d1, d3);
      tessellator.a(d4, par5 + 1.0, d6, d1, d2);
      tessellator.a(d5, par5 + 1.0, d7, d, d2);
      tessellator.a(d5, par5 + 0.0, d7, d, d3);
      tessellator.a(d4, par5 + 0.0, d7, d1, d3);
      tessellator.a(d4, par5 + 1.0, d7, d1, d2);
      tessellator.a(d4, par5 + 1.0, d7, d, d2);
      tessellator.a(d4, par5 + 0.0, d7, d, d3);
      tessellator.a(d5, par5 + 0.0, d7, d1, d3);
      tessellator.a(d5, par5 + 1.0, d7, d1, d2);
   }

   public void renderBlockCropsStripelands(Block par1Block, int par2, double par3, double par5, double par7) {
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.a(0, par2);
      if (this.d >= 0) {
         i = this.d;
      }

      int j = (i & 15) << 4;
      int k = i & 240;
      double d = j / 256.0F;
      double d1 = (j + 15.99F) / 256.0F;
      double d2 = k / 256.0F;
      double d3 = (k + 15.99F) / 256.0F;
      double d4 = par3 + 0.25;
      double d5 = par3 + 0.75;
      double d6 = par7;
      double d7 = par7 + 1.0;
      tessellator.addVertexWithUVNoOffset(d4, par5 + 1.0, d6, d, d2);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 0.0, d6, d, d3);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 0.0, d7, d1, d3);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 1.0, d7, d1, d2);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 1.0, d7, d, d2);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 0.0, d7, d, d3);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 0.0, d6, d1, d3);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 1.0, d6, d1, d2);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 1.0, d7, d, d2);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 0.0, d7, d, d3);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 0.0, d6, d1, d3);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 1.0, d6, d1, d2);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 1.0, d6, d, d2);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 0.0, d6, d, d3);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 0.0, d7, d1, d3);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 1.0, d7, d1, d2);
      d4 = par3;
      d5 = par3 + 1.0;
      d6 = par7 + 0.25;
      d7 = par7 + 0.75;
      tessellator.addVertexWithUVNoOffset(d4, par5 + 1.0, d6, d, d2);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 0.0, d6, d, d3);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 0.0, d6, d1, d3);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 1.0, d6, d1, d2);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 1.0, d6, d, d2);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 0.0, d6, d, d3);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 0.0, d6, d1, d3);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 1.0, d6, d1, d2);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 1.0, d7, d, d2);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 0.0, d7, d, d3);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 0.0, d7, d1, d3);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 1.0, d7, d1, d2);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 1.0, d7, d, d2);
      tessellator.addVertexWithUVNoOffset(d4, par5 + 0.0, d7, d, d3);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 0.0, d7, d1, d3);
      tessellator.addVertexWithUVNoOffset(d5, par5 + 1.0, d7, d1, d2);
   }

   public boolean renderBlockFluids(Block par1Block, long par2, int par3, long par4) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      Tessellator tessellator = Tessellator.a;
      int i = par1Block.colorMultiplier(this.a, par2, par3, par4);
      float f = (i >> 16 & 0xFF) / 255.0F;
      float f1 = (i >> 8 & 0xFF) / 255.0F;
      float f2 = (i & 0xFF) / 255.0F;
      boolean flag = par1Block.shouldSideBeRendered(this.a, par2, par3 + 1, par4, 1);
      boolean flag1 = par1Block.shouldSideBeRendered(this.a, par2, par3 - 1, par4, 0);
      boolean[] aflag = new boolean[]{
         par1Block.shouldSideBeRendered(this.a, par2, par3, par4 - 1L, 2),
         par1Block.shouldSideBeRendered(this.a, par2, par3, par4 + 1L, 3),
         par1Block.shouldSideBeRendered(this.a, par2 - 1L, par3, par4, 4),
         par1Block.shouldSideBeRendered(this.a, par2 + 1L, par3, par4, 5)
      };
      if (!flag && !flag1 && !aflag[0] && !aflag[1] && !aflag[2] && !aflag[3]) {
         return false;
      }

      boolean flag2 = false;
      float f3 = 0.5F;
      float f4 = 1.0F;
      float f5 = 0.8F;
      float f6 = 0.6F;
      double d = 0.0;
      double d1 = 1.0;
      acn material = par1Block.cd;
      int j = this.a.getBlockMetadata(par2, par3, par4);
      double d2 = this.getFluidHeight(par2, par3, par4, material);
      double d3 = this.getFluidHeight(par2, par3, par4 + 1L, material);
      double d4 = this.getFluidHeight(par2 + 1L, par3, par4 + 1L, material);
      double d5 = this.getFluidHeight(par2 + 1L, par3, par4, material);
      double d6 = 0.001F;
      if (this.f || flag) {
         flag2 = true;
         int k = par1Block.a(1, j);
         float f8 = (float)BlockFluid.func_293_a(this.a, par2, par3, par4, material);
         if (f8 > -999.0F) {
            k = par1Block.a(2, j);
         }

         d2 -= d6;
         d3 -= d6;
         d4 -= d6;
         d5 -= d6;
         int j1 = (k & 15) << 4;
         int l1 = k & 240;
         double d7 = (j1 + 8.0) / 256.0;
         double d8 = (l1 + 8.0) / 256.0;
         if (f8 < -999.0F) {
            f8 = 0.0F;
         } else {
            d7 = (j1 + 16) / 256.0F;
            d8 = (l1 + 16) / 256.0F;
         }

         double d10 = MathHelper.a(f8) * 8.0F / 256.0;
         double d12 = MathHelper.b(f8) * 8.0F / 256.0;
         tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4));
         float f9 = 1.0F;
         tessellator.a(f4 * f9 * f, f4 * f9 * f1, f4 * f9 * f2);
         if (useFix) {
            tessellator.addVertexWithUVNoOffset(par2a + 0L, par3a + d2, par4a + 0L, d7 - d12 - d10, d8 - d12 + d10);
            tessellator.addVertexWithUVNoOffset(par2a + 0L, par3a + d3, par4a + 1L, d7 - d12 + d10, d8 + d12 + d10);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + d4, par4a + 1L, d7 + d12 + d10, d8 + d12 - d10);
            tessellator.addVertexWithUVNoOffset(par2a + 1L, par3a + d5, par4a + 0L, d7 + d12 - d10, d8 - d12 - d10);
         } else {
            tessellator.a(par2 + 0L, par3 + d2, par4 + 0L, d7 - d12 - d10, d8 - d12 + d10);
            tessellator.a(par2 + 0L, par3 + d3, par4 + 1L, d7 - d12 + d10, d8 + d12 + d10);
            tessellator.a(par2 + 1L, par3 + d4, par4 + 1L, d7 + d12 + d10, d8 + d12 - d10);
            tessellator.a(par2 + 1L, par3 + d5, par4 + 0L, d7 + d12 - d10, d8 - d12 - d10);
         }
      }

      if (this.f || flag1) {
         tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, par2, par3 - 1, par4));
         float f7 = 1.0F;
         tessellator.a(f3 * f7, f3 * f7, f3 * f7);
         if (useFix) {
            this.renderBottomFace(par1Block, par2a, par3a + d6, par4a, par1Block.a_(0), true);
         } else {
            this.a(par1Block, par2, par3 + d6, par4, par1Block.a_(0));
         }

         flag2 = true;
      }

      for (int l = 0; l < 4; l++) {
         long i1 = par2;
         int k1 = par3;
         long i2 = par4;
         if (l == 0) {
            i2--;
         }

         if (l == 1) {
            i2++;
         }

         if (l == 2) {
            i1--;
         }

         if (l == 3) {
            i1++;
         }

         int j2 = par1Block.a(l + 2, j);
         int k2 = (j2 & 15) << 4;
         int l2 = j2 & 240;
         if (this.f || aflag[l]) {
            double d9;
            double d11;
            double d13;
            double d14;
            double d15;
            double d16;
            double d13Long;
            double d14Long;
            double d15Long;
            double d16Long;
            if (l == 0) {
               d9 = d2;
               d11 = d5;
               d13 = par2;
               d15 = par2 + 1L;
               d14 = par4 + d6;
               d16 = par4 + d6;
               d13Long = par2a;
               d15Long = par2a + 1L;
               d14Long = par4a + d6;
               d16Long = par4a + d6;
            } else if (l == 1) {
               d9 = d4;
               d11 = d3;
               d13 = par2 + 1L;
               d15 = par2;
               d14 = par4 + 1L - d6;
               d16 = par4 + 1L - d6;
               d13Long = par2a + 1L;
               d15Long = par2a;
               d14Long = par4a + 1L - d6;
               d16Long = par4a + 1L - d6;
            } else if (l == 2) {
               d9 = d3;
               d11 = d2;
               d13 = par2 + d6;
               d15 = par2 + d6;
               d14 = par4 + 1L;
               d16 = par4;
               d13Long = par2a + d6;
               d15Long = par2a + d6;
               d14Long = par4a + 1L;
               d16Long = par4a;
            } else {
               d9 = d5;
               d11 = d4;
               d13 = par2 + 1L - d6;
               d15 = par2 + 1L - d6;
               d14 = par4;
               d16 = par4 + 1L;
               d13Long = par2a + 1L - d6;
               d15Long = par2a + 1L - d6;
               d14Long = par4a;
               d16Long = par4a + 1L;
            }

            flag2 = true;
            double d17 = (k2 + 0) / 256.0F;
            double d18 = (k2 + 16 - 0.01) / 256.0;
            double d19 = (l2 + (1.0 - d9) * 16.0) / 256.0;
            double d20 = (l2 + (1.0 - d11) * 16.0) / 256.0;
            double d21 = (l2 + 16 - 0.01) / 256.0;
            tessellator.b(par1Block.getMixedBrightnessForBlock(this.a, i1, k1, i2));
            float f10 = 1.0F;
            if (l < 2) {
               f10 *= f5;
            } else {
               f10 *= f6;
            }

            tessellator.a(f4 * f10 * f, f4 * f10 * f1, f4 * f10 * f2);
            if (useFix) {
               tessellator.addVertexWithUVNoOffset(d13Long, par3a + d9, d14Long, d17, d19);
               tessellator.addVertexWithUVNoOffset(d15Long, par3a + d11, d16Long, d18, d20);
               tessellator.addVertexWithUVNoOffset(d15Long, par3a + 0, d16Long, d18, d21);
               tessellator.addVertexWithUVNoOffset(d13Long, par3a + 0, d14Long, d17, d21);
            } else {
               tessellator.a(d13, par3 + d9, d14, d17, d19);
               tessellator.a(d15, par3 + d11, d16, d18, d20);
               tessellator.a(d15, par3 + 0, d16, d18, d21);
               tessellator.a(d13, par3 + 0, d14, d17, d21);
            }
         }
      }

      par1Block.bW = d;
      par1Block.bZ = d1;
      return flag2;
   }

   private float getFluidHeight(long par1, int par2, long par3, acn par4Material) {
      int i = 0;
      float f = 0.0F;

      for (int j = 0; j < 4; j++) {
         long k = par1 - (j & 1);
         int l = par2;
         long i1 = par3 - (j >> 1 & 1);
         if (this.a.getBlockMaterial(k, l + 1, i1) == par4Material) {
            return 1.0F;
         }

         acn material = this.a.getBlockMaterial(k, l, i1);
         if (material == par4Material) {
            int j1 = this.a.getBlockMetadata(k, l, i1);
            if (j1 >= 8 || j1 == 0) {
               f += BlockFluid.e(j1) * 10.0F;
               i += 10;
            }

            f += BlockFluid.e(j1);
            i++;
         } else if (!material.a()) {
            f++;
            i++;
         }
      }

      return 1.0F - f / i;
   }

   public void renderBlockFallingSand(Block par1Block, World par2World, long par3, int par4, long par5) {
      float f = 0.5F;
      float f1 = 1.0F;
      float f2 = 0.8F;
      float f3 = 0.6F;
      Tessellator tessellator = Tessellator.a;
      tessellator.b();
      tessellator.b(par1Block.getMixedBrightnessForBlock(par2World, par3, par4, par5));
      float f4 = 1.0F;
      float f5 = 1.0F;
      if (f5 < f4) {
         f5 = f4;
      }

      tessellator.a(f * f5, f * f5, f * f5);
      this.a(par1Block, -0.5, -0.5, -0.5, par1Block.a_(0));
      f5 = 1.0F;
      if (f5 < f4) {
         f5 = f4;
      }

      tessellator.a(f1 * f5, f1 * f5, f1 * f5);
      this.b(par1Block, -0.5, -0.5, -0.5, par1Block.a_(1));
      f5 = 1.0F;
      if (f5 < f4) {
         f5 = f4;
      }

      tessellator.a(f2 * f5, f2 * f5, f2 * f5);
      this.c(par1Block, -0.5, -0.5, -0.5, par1Block.a_(2));
      f5 = 1.0F;
      if (f5 < f4) {
         f5 = f4;
      }

      tessellator.a(f2 * f5, f2 * f5, f2 * f5);
      this.d(par1Block, -0.5, -0.5, -0.5, par1Block.a_(3));
      f5 = 1.0F;
      if (f5 < f4) {
         f5 = f4;
      }

      tessellator.a(f3 * f5, f3 * f5, f3 * f5);
      this.e(par1Block, -0.5, -0.5, -0.5, par1Block.a_(4));
      f5 = 1.0F;
      if (f5 < f4) {
         f5 = f4;
      }

      tessellator.a(f3 * f5, f3 * f5, f3 * f5);
      this.f(par1Block, -0.5, -0.5, -0.5, par1Block.a_(5));
      tessellator.a();
   }

   public boolean renderStandardBlock(Block par1Block, long par2, int par3, long par4) {
      int i = par1Block.colorMultiplier(this.a, par2, par3, par4);
      float f = (i >> 16 & 0xFF) / 255.0F;
      float f1 = (i >> 8 & 0xFF) / 255.0F;
      float f2 = (i & 0xFF) / 255.0F;
      if (EntityRenderer.a) {
         float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
         float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
         float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
         f = f3;
         f1 = f4;
         f2 = f5;
      }

      return Minecraft.t() && Block.q[par1Block.bO] == 0
         ? this.renderStandardBlockWithAmbientOcclusion(par1Block, par2, par3, par4, f, f1, f2)
         : this.renderStandardBlockWithColorMultiplier(par1Block, par2, par3, par4, f, f1, f2);
   }

   public boolean renderStandardBlockWithAmbientOcclusion(Block par1Block, long par2, int par3, long par4, float par5, float par6, float par7) {
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      boolean useFix = stripeLandsFix && !this.isHitbox;
      this.m = true;
      boolean flag = false;
      float f = this.n;
      float f7 = this.n;
      float f14 = this.n;
      float f21 = this.n;
      boolean flag1 = true;
      boolean flag2 = true;
      boolean flag3 = true;
      boolean flag4 = true;
      boolean flag5 = true;
      boolean flag6 = true;
      this.n = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3, par4);
      this.o = par1Block.getAmbientOcclusionLightValue(this.a, par2 - 1L, par3, par4);
      this.p = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 - 1, par4);
      this.q = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3, par4 - 1L);
      this.r = par1Block.getAmbientOcclusionLightValue(this.a, par2 + 1L, par3, par4);
      this.s = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 + 1, par4);
      this.t = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3, par4 + 1L);
      int i = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4);
      int j = i;
      int k = i;
      int l = i;
      int i1 = i;
      int j1 = i;
      int k1 = i;
      if (par1Block.bW <= 0.0) {
         k = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 - 1, par4);
      }

      if (par1Block.bZ >= 1.0) {
         j1 = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 + 1, par4);
      }

      if (par1Block.bV <= 0.0) {
         j = par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3, par4);
      }

      if (par1Block.bY >= 1.0) {
         i1 = par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3, par4);
      }

      if (par1Block.bX <= 0.0) {
         l = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 - 1L);
      }

      if (par1Block.IChunkProvider >= 1.0) {
         k1 = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 + 1L);
      }

      Tessellator tessellator = Tessellator.a;
      tessellator.b(983055);
      this.aA = Block.p[this.a.getBlockId(par2 + 1L, par3 + 1, par4)];
      this.aI = Block.p[this.a.getBlockId(par2 + 1L, par3 - 1, par4)];
      this.aE = Block.p[this.a.getBlockId(par2 + 1L, par3, par4 + 1L)];
      this.aG = Block.p[this.a.getBlockId(par2 + 1L, par3, par4 - 1L)];
      this.aB = Block.p[this.a.getBlockId(par2 - 1L, par3 + 1, par4)];
      this.aJ = Block.p[this.a.getBlockId(par2 - 1L, par3 - 1, par4)];
      this.aD = Block.p[this.a.getBlockId(par2 - 1L, par3, par4 - 1L)];
      this.aF = Block.p[this.a.getBlockId(par2 - 1L, par3, par4 + 1L)];
      this.aC = Block.p[this.a.getBlockId(par2, par3 + 1, par4 + 1L)];
      this.TileEntityDispenser = Block.p[this.a.getBlockId(par2, par3 + 1, par4 - 1L)];
      this.aK = Block.p[this.a.getBlockId(par2, par3 - 1, par4 + 1L)];
      this.aH = Block.p[this.a.getBlockId(par2, par3 - 1, par4 - 1L)];
      if (par1Block.bN == 3) {
         flag6 = false;
         flag5 = false;
         flag4 = false;
         flag3 = false;
         flag1 = false;
      }

      if (this.d >= 0) {
         flag6 = false;
         flag5 = false;
         flag4 = false;
         flag3 = false;
         flag1 = false;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3 - 1, par4, 0)) {
         float f1;
         float f8;
         float f15;
         float f22;
         if (this.ai > 0) {
            if (par1Block.bW <= 0.0) {
               par3--;
            }

            this.P = par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3, par4);
            this.R = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 - 1L);
            this.S = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 + 1L);
            this.U = par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3, par4);
            this.v = par1Block.getAmbientOcclusionLightValue(this.a, par2 - 1L, par3, par4);
            this.x = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3, par4 - 1L);
            this.y = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3, par4 + 1L);
            this.A = par1Block.getAmbientOcclusionLightValue(this.a, par2 + 1L, par3, par4);
            if (!this.aH && !this.aJ) {
               this.u = this.v;
               this.O = this.P;
            } else {
               this.u = par1Block.getAmbientOcclusionLightValue(this.a, par2 - 1L, par3, par4 - 1L);
               this.O = par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3, par4 - 1L);
            }

            if (!this.aK && !this.aJ) {
               this.w = this.v;
               this.Q = this.P;
            } else {
               this.w = par1Block.getAmbientOcclusionLightValue(this.a, par2 - 1L, par3, par4 + 1L);
               this.Q = par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3, par4 + 1L);
            }

            if (!this.aH && !this.aI) {
               this.z = this.A;
               this.T = this.U;
            } else {
               this.z = par1Block.getAmbientOcclusionLightValue(this.a, par2 + 1L, par3, par4 - 1L);
               this.T = par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3, par4 - 1L);
            }

            if (!this.aK && !this.aI) {
               this.B = this.A;
               this.V = this.U;
            } else {
               this.B = par1Block.getAmbientOcclusionLightValue(this.a, par2 + 1L, par3, par4 + 1L);
               this.V = par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3, par4 + 1L);
            }

            if (par1Block.bW <= 0.0) {
               par3++;
            }

            f1 = (this.w + this.v + this.y + this.p) / 4.0F;
            f22 = (this.y + this.p + this.B + this.A) / 4.0F;
            f15 = (this.p + this.x + this.A + this.z) / 4.0F;
            f8 = (this.v + this.u + this.p + this.x) / 4.0F;
            this.aj = this.a(this.Q, this.P, this.S, k);
            this.NoiseGeneratorPerlin = this.a(this.S, this.V, this.U, k);
            this.BlockPortal = this.a(this.R, this.U, this.T, k);
            this.ak = this.a(this.P, this.O, this.R, k);
         } else {
            f22 = this.p;
            f15 = this.p;
            f8 = this.p;
            f1 = this.p;
            this.aj = this.ak = this.BlockPortal = this.NoiseGeneratorPerlin = this.P;
         }

         this.MapGenVillage = this.GenLayerHills = this.ap = this.aq = (flag1 ? par5 : 1.0F) * 0.5F;
         this.ar = this.as = this.at = this.au = (flag1 ? par6 : 1.0F) * 0.5F;
         this.EntityThrowable = this.aw = this.EntityAIAttackOnCollide = this.StructureNetherBridgeStart = (flag1 ? par7 : 1.0F) * 0.5F;
         this.MapGenVillage *= f1;
         this.ar *= f1;
         this.EntityThrowable *= f1;
         this.GenLayerHills *= f8;
         this.as *= f8;
         this.aw *= f8;
         this.ap *= f15;
         this.at *= f15;
         this.EntityAIAttackOnCollide *= f15;
         this.aq *= f22;
         this.au *= f22;
         this.StructureNetherBridgeStart *= f22;
         if (useFix) {
            this.renderBottomFace(par1Block, par2a, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 0), true);
         } else {
            this.a(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 0));
         }

         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3 + 1, par4, 1)) {
         float f2;
         float f9;
         float f16;
         float f23;
         if (this.ai > 0) {
            if (par1Block.bZ >= 1.0) {
               par3++;
            }

            this.X = par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3, par4);
            this.ab = par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3, par4);
            this.Z = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 - 1L);
            this.EntityNoteFX = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 + 1L);
            this.D = par1Block.getAmbientOcclusionLightValue(this.a, par2 - 1L, par3, par4);
            this.H = par1Block.getAmbientOcclusionLightValue(this.a, par2 + 1L, par3, par4);
            this.F = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3, par4 - 1L);
            this.I = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3, par4 + 1L);
            if (!this.TileEntityDispenser && !this.aB) {
               this.C = this.D;
               this.W = this.X;
            } else {
               this.C = par1Block.getAmbientOcclusionLightValue(this.a, par2 - 1L, par3, par4 - 1L);
               this.W = par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3, par4 - 1L);
            }

            if (!this.TileEntityDispenser && !this.aA) {
               this.G = this.H;
               this.BlockSnowBlock = this.ab;
            } else {
               this.G = par1Block.getAmbientOcclusionLightValue(this.a, par2 + 1L, par3, par4 - 1L);
               this.BlockSnowBlock = par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3, par4 - 1L);
            }

            if (!this.aC && !this.aB) {
               this.E = this.D;
               this.Y = this.X;
            } else {
               this.E = par1Block.getAmbientOcclusionLightValue(this.a, par2 - 1L, par3, par4 + 1L);
               this.Y = par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3, par4 + 1L);
            }

            if (!this.aC && !this.aA) {
               this.J = this.H;
               this.ad = this.ab;
            } else {
               this.J = par1Block.getAmbientOcclusionLightValue(this.a, par2 + 1L, par3, par4 + 1L);
               this.ad = par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3, par4 + 1L);
            }

            if (par1Block.bZ >= 1.0) {
               par3--;
            }

            f23 = (this.E + this.D + this.I + this.s) / 4.0F;
            f2 = (this.I + this.s + this.J + this.H) / 4.0F;
            f9 = (this.s + this.F + this.H + this.G) / 4.0F;
            f16 = (this.D + this.C + this.s + this.F) / 4.0F;
            this.NoiseGeneratorPerlin = this.a(this.Y, this.X, this.EntityNoteFX, j1);
            this.aj = this.a(this.EntityNoteFX, this.ad, this.ab, j1);
            this.ak = this.a(this.Z, this.ab, this.BlockSnowBlock, j1);
            this.BlockPortal = this.a(this.X, this.W, this.Z, j1);
         } else {
            f23 = this.s;
            f16 = this.s;
            f9 = this.s;
            f2 = this.s;
            this.aj = this.ak = this.BlockPortal = this.NoiseGeneratorPerlin = j1;
         }

         this.MapGenVillage = this.GenLayerHills = this.ap = this.aq = flag2 ? par5 : 1.0F;
         this.ar = this.as = this.at = this.au = flag2 ? par6 : 1.0F;
         this.EntityThrowable = this.aw = this.EntityAIAttackOnCollide = this.StructureNetherBridgeStart = flag2 ? par7 : 1.0F;
         this.MapGenVillage *= f2;
         this.ar *= f2;
         this.EntityThrowable *= f2;
         this.GenLayerHills *= f9;
         this.as *= f9;
         this.aw *= f9;
         this.ap *= f16;
         this.at *= f16;
         this.EntityAIAttackOnCollide *= f16;
         this.aq *= f23;
         this.au *= f23;
         this.StructureNetherBridgeStart *= f23;
         if (useFix) {
            this.renderTopFace(par1Block, par2a, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 1), true);
         } else {
            this.b(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 1));
         }

         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3, par4 - 1L, 2)) {
         float f3;
         float f10;
         float f17;
         float f24;
         if (this.ai > 0) {
            if (par1Block.bX <= 0.0) {
               par4--;
            }

            this.K = par1Block.getAmbientOcclusionLightValue(this.a, par2 - 1L, par3, par4);
            this.x = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 - 1, par4);
            this.F = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 + 1, par4);
            this.L = par1Block.getAmbientOcclusionLightValue(this.a, par2 + 1L, par3, par4);
            this.BlockTNT = par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3, par4);
            this.R = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 - 1, par4);
            this.Z = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 + 1, par4);
            this.TileEntityMobSpawnerRenderer = par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3, par4);
            if (!this.aD && !this.aH) {
               this.u = this.K;
               this.O = this.BlockTNT;
            } else {
               this.u = par1Block.getAmbientOcclusionLightValue(this.a, par2 - 1L, par3 - 1, par4);
               this.O = par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3 - 1, par4);
            }

            if (!this.aD && !this.TileEntityDispenser) {
               this.C = this.K;
               this.W = this.BlockTNT;
            } else {
               this.C = par1Block.getAmbientOcclusionLightValue(this.a, par2 - 1L, par3 + 1, par4);
               this.W = par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3 + 1, par4);
            }

            if (!this.aG && !this.aH) {
               this.z = this.L;
               this.T = this.TileEntityMobSpawnerRenderer;
            } else {
               this.z = par1Block.getAmbientOcclusionLightValue(this.a, par2 + 1L, par3 - 1, par4);
               this.T = par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3 - 1, par4);
            }

            if (!this.aG && !this.TileEntityDispenser) {
               this.G = this.L;
               this.BlockSnowBlock = this.TileEntityMobSpawnerRenderer;
            } else {
               this.G = par1Block.getAmbientOcclusionLightValue(this.a, par2 + 1L, par3 + 1, par4);
               this.BlockSnowBlock = par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3 + 1, par4);
            }

            if (par1Block.bX <= 0.0) {
               par4++;
            }

            f3 = (this.K + this.C + this.q + this.F) / 4.0F;
            f10 = (this.q + this.F + this.L + this.G) / 4.0F;
            f17 = (this.x + this.q + this.z + this.L) / 4.0F;
            f24 = (this.u + this.K + this.x + this.q) / 4.0F;
            this.aj = this.a(this.BlockTNT, this.W, this.Z, l);
            this.ak = this.a(this.Z, this.TileEntityMobSpawnerRenderer, this.BlockSnowBlock, l);
            this.BlockPortal = this.a(this.R, this.T, this.TileEntityMobSpawnerRenderer, l);
            this.NoiseGeneratorPerlin = this.a(this.O, this.BlockTNT, this.R, l);
         } else {
            f24 = this.q;
            f17 = this.q;
            f10 = this.q;
            f3 = this.q;
            this.aj = this.ak = this.BlockPortal = this.NoiseGeneratorPerlin = l;
         }

         this.MapGenVillage = this.GenLayerHills = this.ap = this.aq = (flag3 ? par5 : 1.0F) * 0.8F;
         this.ar = this.as = this.at = this.au = (flag3 ? par6 : 1.0F) * 0.8F;
         this.EntityThrowable = this.aw = this.EntityAIAttackOnCollide = this.StructureNetherBridgeStart = (flag3 ? par7 : 1.0F) * 0.8F;
         this.MapGenVillage *= f3;
         this.ar *= f3;
         this.EntityThrowable *= f3;
         this.GenLayerHills *= f10;
         this.as *= f10;
         this.aw *= f10;
         this.ap *= f17;
         this.at *= f17;
         this.EntityAIAttackOnCollide *= f17;
         this.aq *= f24;
         this.au *= f24;
         this.StructureNetherBridgeStart *= f24;
         int l1 = par1Block.getBlockTexture(this.a, par2, par3, par4, 2);
         if (useFix) {
            this.renderEastFace(par1Block, par2a, par3a, par4a, l1, true);
         } else {
            this.c(par1Block, par2, par3, par4, l1);
         }

         if (b && l1 == 3 && this.d < 0) {
            this.MapGenVillage *= par5;
            this.GenLayerHills *= par5;
            this.ap *= par5;
            this.aq *= par5;
            this.ar *= par6;
            this.as *= par6;
            this.at *= par6;
            this.au *= par6;
            this.EntityThrowable *= par7;
            this.aw *= par7;
            this.EntityAIAttackOnCollide *= par7;
            this.StructureNetherBridgeStart *= par7;
            if (useFix) {
               this.renderEastFace(par1Block, par2a, par3a, par4a, 38, true);
            } else {
               this.c(par1Block, par2, par3, par4, 38);
            }
         }

         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3, par4 + 1L, 3)) {
         float f4;
         float f11;
         float f18;
         float f25;
         if (this.ai > 0) {
            if (par1Block.IChunkProvider >= 1.0) {
               par4++;
            }

            this.M = par1Block.getAmbientOcclusionLightValue(this.a, par2 - 1L, par3, par4);
            this.N = par1Block.getAmbientOcclusionLightValue(this.a, par2 + 1L, par3, par4);
            this.y = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 - 1, par4);
            this.I = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 + 1, par4);
            this.ag = par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3, par4);
            this.ah = par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3, par4);
            this.S = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 - 1, par4);
            this.EntityNoteFX = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 + 1, par4);
            if (!this.aF && !this.aK) {
               this.w = this.M;
               this.Q = this.ag;
            } else {
               this.w = par1Block.getAmbientOcclusionLightValue(this.a, par2 - 1L, par3 - 1, par4);
               this.Q = par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3 - 1, par4);
            }

            if (!this.aF && !this.aC) {
               this.E = this.M;
               this.Y = this.ag;
            } else {
               this.E = par1Block.getAmbientOcclusionLightValue(this.a, par2 - 1L, par3 + 1, par4);
               this.Y = par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3 + 1, par4);
            }

            if (!this.aE && !this.aK) {
               this.B = this.N;
               this.V = this.ah;
            } else {
               this.B = par1Block.getAmbientOcclusionLightValue(this.a, par2 + 1L, par3 - 1, par4);
               this.V = par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3 - 1, par4);
            }

            if (!this.aE && !this.aC) {
               this.J = this.N;
               this.ad = this.ah;
            } else {
               this.J = par1Block.getAmbientOcclusionLightValue(this.a, par2 + 1L, par3 + 1, par4);
               this.ad = par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3 + 1, par4);
            }

            if (par1Block.IChunkProvider >= 1.0) {
               par4--;
            }

            f4 = (this.M + this.E + this.t + this.I) / 4.0F;
            f25 = (this.t + this.I + this.N + this.J) / 4.0F;
            f18 = (this.y + this.t + this.B + this.N) / 4.0F;
            f11 = (this.w + this.M + this.y + this.t) / 4.0F;
            this.aj = this.a(this.ag, this.Y, this.EntityNoteFX, k1);
            this.NoiseGeneratorPerlin = this.a(this.EntityNoteFX, this.ah, this.ad, k1);
            this.BlockPortal = this.a(this.S, this.V, this.ah, k1);
            this.ak = this.a(this.Q, this.ag, this.S, k1);
         } else {
            f25 = this.t;
            f18 = this.t;
            f11 = this.t;
            f4 = this.t;
            this.aj = this.ak = this.BlockPortal = this.NoiseGeneratorPerlin = k1;
         }

         this.MapGenVillage = this.GenLayerHills = this.ap = this.aq = (flag4 ? par5 : 1.0F) * 0.8F;
         this.ar = this.as = this.at = this.au = (flag4 ? par6 : 1.0F) * 0.8F;
         this.EntityThrowable = this.aw = this.EntityAIAttackOnCollide = this.StructureNetherBridgeStart = (flag4 ? par7 : 1.0F) * 0.8F;
         this.MapGenVillage *= f4;
         this.ar *= f4;
         this.EntityThrowable *= f4;
         this.GenLayerHills *= f11;
         this.as *= f11;
         this.aw *= f11;
         this.ap *= f18;
         this.at *= f18;
         this.EntityAIAttackOnCollide *= f18;
         this.aq *= f25;
         this.au *= f25;
         this.StructureNetherBridgeStart *= f25;
         int i2 = par1Block.getBlockTexture(this.a, par2, par3, par4, 3);
         if (useFix) {
            this.renderWestFace(par1Block, par2a, par3a, par4a, i2, true);
         } else {
            this.d(par1Block, par2, par3, par4, i2);
         }

         if (b && i2 == 3 && this.d < 0) {
            this.MapGenVillage *= par5;
            this.GenLayerHills *= par5;
            this.ap *= par5;
            this.aq *= par5;
            this.ar *= par6;
            this.as *= par6;
            this.at *= par6;
            this.au *= par6;
            this.EntityThrowable *= par7;
            this.aw *= par7;
            this.EntityAIAttackOnCollide *= par7;
            this.StructureNetherBridgeStart *= par7;
            if (useFix) {
               this.renderWestFace(par1Block, par2a, par3a, par4a, 38, true);
            } else {
               this.d(par1Block, par2, par3, par4, 38);
            }
         }

         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2 - 1L, par3, par4, 4)) {
         float f5;
         float f12;
         float f19;
         float f26;
         if (this.ai > 0) {
            if (par1Block.bV <= 0.0) {
               par2--;
            }

            this.v = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 - 1, par4);
            this.K = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3, par4 - 1L);
            this.M = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3, par4 + 1L);
            this.D = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 + 1, par4);
            this.P = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 - 1, par4);
            this.BlockTNT = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 - 1L);
            this.ag = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 + 1L);
            this.X = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 + 1, par4);
            if (!this.aD && !this.aJ) {
               this.u = this.K;
               this.O = this.BlockTNT;
            } else {
               this.u = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 - 1, par4 - 1L);
               this.O = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 - 1, par4 - 1L);
            }

            if (!this.aF && !this.aJ) {
               this.w = this.M;
               this.Q = this.ag;
            } else {
               this.w = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 - 1, par4 + 1L);
               this.Q = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 - 1, par4 + 1L);
            }

            if (!this.aD && !this.aB) {
               this.C = this.K;
               this.W = this.BlockTNT;
            } else {
               this.C = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 + 1, par4 - 1L);
               this.W = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 + 1, par4 - 1L);
            }

            if (!this.aF && !this.aB) {
               this.E = this.M;
               this.Y = this.ag;
            } else {
               this.E = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 + 1, par4 + 1L);
               this.Y = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 + 1, par4 + 1L);
            }

            if (par1Block.bV <= 0.0) {
               par2++;
            }

            f26 = (this.v + this.w + this.o + this.M) / 4.0F;
            f5 = (this.o + this.M + this.D + this.E) / 4.0F;
            f12 = (this.K + this.o + this.C + this.D) / 4.0F;
            f19 = (this.u + this.v + this.K + this.o) / 4.0F;
            this.NoiseGeneratorPerlin = this.a(this.P, this.Q, this.ag, j);
            this.aj = this.a(this.ag, this.X, this.Y, j);
            this.ak = this.a(this.BlockTNT, this.W, this.X, j);
            this.BlockPortal = this.a(this.O, this.P, this.BlockTNT, j);
         } else {
            f26 = this.o;
            f19 = this.o;
            f12 = this.o;
            f5 = this.o;
            this.aj = this.ak = this.BlockPortal = this.NoiseGeneratorPerlin = j;
         }

         this.MapGenVillage = this.GenLayerHills = this.ap = this.aq = (flag5 ? par5 : 1.0F) * 0.6F;
         this.ar = this.as = this.at = this.au = (flag5 ? par6 : 1.0F) * 0.6F;
         this.EntityThrowable = this.aw = this.EntityAIAttackOnCollide = this.StructureNetherBridgeStart = (flag5 ? par7 : 1.0F) * 0.6F;
         this.MapGenVillage *= f5;
         this.ar *= f5;
         this.EntityThrowable *= f5;
         this.GenLayerHills *= f12;
         this.as *= f12;
         this.aw *= f12;
         this.ap *= f19;
         this.at *= f19;
         this.EntityAIAttackOnCollide *= f19;
         this.aq *= f26;
         this.au *= f26;
         this.StructureNetherBridgeStart *= f26;
         int j2 = par1Block.getBlockTexture(this.a, par2, par3, par4, 4);
         if (useFix) {
            this.renderNorthFace(par1Block, par2a, par3a, par4a, j2, true);
         } else {
            this.e(par1Block, par2, par3, par4, j2);
         }

         if (b && j2 == 3 && this.d < 0) {
            this.MapGenVillage *= par5;
            this.GenLayerHills *= par5;
            this.ap *= par5;
            this.aq *= par5;
            this.ar *= par6;
            this.as *= par6;
            this.at *= par6;
            this.au *= par6;
            this.EntityThrowable *= par7;
            this.aw *= par7;
            this.EntityAIAttackOnCollide *= par7;
            this.StructureNetherBridgeStart *= par7;
            if (useFix) {
               this.renderNorthFace(par1Block, par2a, par3a, par4a, 38, true);
            } else {
               this.e(par1Block, par2, par3, par4, 38);
            }
         }

         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2 + 1L, par3, par4, 5)) {
         float f6;
         float f13;
         float f20;
         float f27;
         if (this.ai > 0) {
            if (par1Block.bY >= 1.0) {
               par2++;
            }

            this.A = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 - 1, par4);
            this.L = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3, par4 - 1L);
            this.N = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3, par4 + 1L);
            this.H = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 + 1, par4);
            this.U = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 - 1, par4);
            this.TileEntityMobSpawnerRenderer = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 - 1L);
            this.ah = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 + 1L);
            this.ab = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 + 1, par4);
            if (!this.aI && !this.aG) {
               this.z = this.L;
               this.T = this.TileEntityMobSpawnerRenderer;
            } else {
               this.z = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 - 1, par4 - 1L);
               this.T = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 - 1, par4 - 1L);
            }

            if (!this.aI && !this.aE) {
               this.B = this.N;
               this.V = this.ah;
            } else {
               this.B = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 - 1, par4 + 1L);
               this.V = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 - 1, par4 + 1L);
            }

            if (!this.aA && !this.aG) {
               this.G = this.L;
               this.BlockSnowBlock = this.TileEntityMobSpawnerRenderer;
            } else {
               this.G = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 + 1, par4 - 1L);
               this.BlockSnowBlock = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 + 1, par4 - 1L);
            }

            if (!this.aA && !this.aE) {
               this.J = this.N;
               this.ad = this.ah;
            } else {
               this.J = par1Block.getAmbientOcclusionLightValue(this.a, par2, par3 + 1, par4 + 1L);
               this.ad = par1Block.getMixedBrightnessForBlock(this.a, par2, par3 + 1, par4 + 1L);
            }

            if (par1Block.bY >= 1.0) {
               par2--;
            }

            f6 = (this.A + this.B + this.r + this.N) / 4.0F;
            f27 = (this.r + this.N + this.H + this.J) / 4.0F;
            f20 = (this.L + this.r + this.G + this.H) / 4.0F;
            f13 = (this.z + this.A + this.L + this.r) / 4.0F;
            this.aj = this.a(this.U, this.V, this.ah, i1);
            this.NoiseGeneratorPerlin = this.a(this.ah, this.ab, this.ad, i1);
            this.BlockPortal = this.a(this.TileEntityMobSpawnerRenderer, this.BlockSnowBlock, this.ab, i1);
            this.ak = this.a(this.T, this.U, this.TileEntityMobSpawnerRenderer, i1);
         } else {
            f27 = this.r;
            f20 = this.r;
            f13 = this.r;
            f6 = this.r;
            this.aj = this.ak = this.BlockPortal = this.NoiseGeneratorPerlin = i1;
         }

         this.MapGenVillage = this.GenLayerHills = this.ap = this.aq = (flag6 ? par5 : 1.0F) * 0.6F;
         this.ar = this.as = this.at = this.au = (flag6 ? par6 : 1.0F) * 0.6F;
         this.EntityThrowable = this.aw = this.EntityAIAttackOnCollide = this.StructureNetherBridgeStart = (flag6 ? par7 : 1.0F) * 0.6F;
         this.MapGenVillage *= f6;
         this.ar *= f6;
         this.EntityThrowable *= f6;
         this.GenLayerHills *= f13;
         this.as *= f13;
         this.aw *= f13;
         this.ap *= f20;
         this.at *= f20;
         this.EntityAIAttackOnCollide *= f20;
         this.aq *= f27;
         this.au *= f27;
         this.StructureNetherBridgeStart *= f27;
         int k2 = par1Block.getBlockTexture(this.a, par2, par3, par4, 5);
         if (useFix) {
            this.renderSouthFace(par1Block, par2a, par3a, par4a, k2, true);
         } else {
            this.f(par1Block, par2, par3, par4, k2);
         }

         if (b && k2 == 3 && this.d < 0) {
            this.MapGenVillage *= par5;
            this.GenLayerHills *= par5;
            this.ap *= par5;
            this.aq *= par5;
            this.ar *= par6;
            this.as *= par6;
            this.at *= par6;
            this.au *= par6;
            this.EntityThrowable *= par7;
            this.aw *= par7;
            this.EntityAIAttackOnCollide *= par7;
            this.StructureNetherBridgeStart *= par7;
            if (useFix) {
               this.renderSouthFace(par1Block, par2a, par3a, par4a, 38, true);
            } else {
               this.f(par1Block, par2, par3, par4, 38);
            }
         }

         flag = true;
      }

      this.m = false;
      return flag;
   }

   private int a(int par1, int par2, int par3, int par4) {
      if (par1 == 0) {
         par1 = par4;
      }

      if (par2 == 0) {
         par2 = par4;
      }

      if (par3 == 0) {
         par3 = par4;
      }

      return par1 + par2 + par3 + par4 >> 2 & 16711935;
   }

   public boolean renderStandardBlockWithColorMultiplier(Block par1Block, long par2, int par3, long par4, float par5, float par6, float par7) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      this.m = false;
      Tessellator tessellator = Tessellator.a;
      boolean flag = false;
      float f = 0.5F;
      float f1 = 1.0F;
      float f2 = 0.8F;
      float f3 = 0.6F;
      float f4 = f1 * par5;
      float f5 = f1 * par6;
      float f6 = f1 * par7;
      float f7 = f;
      float f8 = f2;
      float f9 = f3;
      float f10 = f;
      float f11 = f2;
      float f12 = f3;
      float f13 = f;
      float f14 = f2;
      float f15 = f3;
      if (par1Block != Block.u) {
         f7 *= par5;
         f8 *= par5;
         f9 *= par5;
         f10 *= par6;
         f11 *= par6;
         f12 *= par6;
         f13 *= par7;
         f14 *= par7;
         f15 *= par7;
      }

      int i = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4);
      if (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3 - 1, par4, 0)) {
         tessellator.b(par1Block.bW <= 0.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3 - 1, par4) : i);
         tessellator.a(f7, f10, f13);
         if (useFix) {
            this.renderBottomFace(par1Block, par2a, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 0), true);
         } else {
            this.a(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 0));
         }

         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3 + 1, par4, 1)) {
         tessellator.b(par1Block.bZ >= 1.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3 + 1, par4) : i);
         tessellator.a(f4, f5, f6);
         if (useFix) {
            this.renderTopFace(par1Block, par2a, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 1), true);
         } else {
            this.b(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 1));
         }

         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3, par4 - 1L, 2)) {
         tessellator.b(par1Block.bX <= 0.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 - 1L) : i);
         tessellator.a(f8, f11, f14);
         int j = par1Block.getBlockTexture(this.a, par2, par3, par4, 2);
         if (useFix) {
            this.renderEastFace(par1Block, par2a, par3a, par4a, j, true);
         } else {
            this.c(par1Block, par2, par3, par4, j);
         }

         if (b && j == 3 && this.d < 0) {
            tessellator.a(f8 * par5, f11 * par6, f14 * par7);
            if (useFix) {
               this.renderEastFace(par1Block, par2a, par3a, par4a, 38, true);
            } else {
               this.c(par1Block, par2, par3, par4, 38);
            }
         }

         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3, par4 + 1L, 3)) {
         tessellator.b(par1Block.IChunkProvider >= 1.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 + 1L) : i);
         tessellator.a(f8, f11, f14);
         int k = par1Block.getBlockTexture(this.a, par2, par3, par4, 3);
         if (useFix) {
            this.renderWestFace(par1Block, par2a, par3a, par4a, k, true);
         } else {
            this.d(par1Block, par2, par3, par4, k);
         }

         if (b && k == 3 && this.d < 0) {
            tessellator.a(f8 * par5, f11 * par6, f14 * par7);
            if (useFix) {
               this.renderWestFace(par1Block, par2a, par3a, par4a, 38, true);
            } else {
               this.d(par1Block, par2, par3, par4, 38);
            }
         }

         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2 - 1L, par3, par4, 4)) {
         tessellator.b(par1Block.bV <= 0.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3, par4) : i);
         tessellator.a(f9, f12, f15);
         int l = par1Block.getBlockTexture(this.a, par2, par3, par4, 4);
         if (useFix) {
            this.renderNorthFace(par1Block, par2a, par3a, par4a, l, true);
         } else {
            this.e(par1Block, par2, par3, par4, l);
         }

         if (b && l == 3 && this.d < 0) {
            tessellator.a(f9 * par5, f12 * par6, f15 * par7);
            if (useFix) {
               this.renderNorthFace(par1Block, par2a, par3a, par4a, 38, true);
            } else {
               this.e(par1Block, par2, par3, par4, 38);
            }
         }

         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2 + 1L, par3, par4, 5)) {
         tessellator.b(par1Block.bY >= 1.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3, par4) : i);
         tessellator.a(f9, f12, f15);
         int i1 = par1Block.getBlockTexture(this.a, par2, par3, par4, 5);
         if (useFix) {
            this.renderSouthFace(par1Block, par2a, par3a, par4a, i1, true);
         } else {
            this.f(par1Block, par2, par3, par4, i1);
         }

         if (b && i1 == 3 && this.d < 0) {
            tessellator.a(f9 * par5, f12 * par6, f15 * par7);
            if (useFix) {
               this.renderSouthFace(par1Block, par2a, par3a, par4a, 38, true);
            } else {
               this.f(par1Block, par2, par3, par4, 38);
            }
         }

         flag = true;
      }

      return flag;
   }

   public boolean renderBlockCactus(Block par1Block, long par2, int par3, long par4) {
      int i = par1Block.colorMultiplier(this.a, par2, par3, par4);
      float f = (i >> 16 & 0xFF) / 255.0F;
      float f1 = (i >> 8 & 0xFF) / 255.0F;
      float f2 = (i & 0xFF) / 255.0F;
      if (EntityRenderer.a) {
         float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
         float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
         float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
         f = f3;
         f1 = f4;
         f2 = f5;
      }

      return this.renderBlockCactusImpl(par1Block, par2, par3, par4, f, f1, f2);
   }

   public boolean renderBlockCactusImpl(Block par1Block, long par2, int par3, long par4, float par5, float par6, float par7) {
      boolean useFix = stripeLandsFix && !this.isHitbox;
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      Tessellator tessellator = Tessellator.a;
      boolean flag = false;
      float f = 0.5F;
      float f1 = 1.0F;
      float f2 = 0.8F;
      float f3 = 0.6F;
      float f4 = f * par5;
      float f5 = f1 * par5;
      float f6 = f2 * par5;
      float f7 = f3 * par5;
      float f8 = f * par6;
      float f9 = f1 * par6;
      float f10 = f2 * par6;
      float f11 = f3 * par6;
      float f12 = f * par7;
      float f13 = f1 * par7;
      float f14 = f2 * par7;
      float f15 = f3 * par7;
      float f16 = 0.0625F;
      int i = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4);
      if (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3 - 1, par4, 0)) {
         tessellator.b(par1Block.bW <= 0.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3 - 1, par4) : i);
         tessellator.a(f4, f8, f12);
         if (useFix) {
            this.renderBottomFace(par1Block, par2a, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 0), true);
         } else {
            this.a(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 0));
         }

         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3 + 1, par4, 1)) {
         tessellator.b(par1Block.bZ >= 1.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3 + 1, par4) : i);
         tessellator.a(f5, f9, f13);
         if (useFix) {
            this.renderTopFace(par1Block, par2a, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 1), true);
         } else {
            this.b(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 1));
         }

         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3, par4 - 1L, 2)) {
         tessellator.b(par1Block.bX <= 0.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 - 1L) : i);
         tessellator.a(f6, f10, f14);
         tessellator.c(0.0F, 0.0F, f16);
         if (useFix) {
            this.renderEastFace(par1Block, par2a, par3a, (double)par4a + f16, par1Block.getBlockTexture(this.a, par2, par3, par4, 2), true);
         } else {
            this.c(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 2));
         }

         tessellator.c(0.0F, 0.0F, -f16);
         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2, par3, par4 + 1L, 3)) {
         tessellator.b(par1Block.IChunkProvider >= 1.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 + 1L) : i);
         tessellator.a(f6, f10, f14);
         tessellator.c(0.0F, 0.0F, -f16);
         if (useFix) {
            this.renderWestFace(par1Block, par2a, par3a, (double)par4a - f16, par1Block.getBlockTexture(this.a, par2, par3, par4, 3), true);
         } else {
            this.d(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 3));
         }

         tessellator.c(0.0F, 0.0F, f16);
         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2 - 1L, par3, par4, 4)) {
         tessellator.b(par1Block.bV <= 0.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3, par4) : i);
         tessellator.a(f7, f11, f15);
         tessellator.c(f16, 0.0F, 0.0F);
         if (useFix) {
            this.renderNorthFace(par1Block, (double)par2a + f16, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 4), true);
         } else {
            this.e(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 4));
         }

         tessellator.c(-f16, 0.0F, 0.0F);
         flag = true;
      }

      if (this.f || par1Block.shouldSideBeRendered(this.a, par2 + 1L, par3, par4, 5)) {
         tessellator.b(par1Block.bY >= 1.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3, par4) : i);
         tessellator.a(f7, f11, f15);
         tessellator.c(-f16, 0.0F, 0.0F);
         if (useFix) {
            this.renderSouthFace(par1Block, (double)par2a - f16, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 5), true);
         } else {
            this.f(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 5));
         }

         tessellator.c(f16, 0.0F, 0.0F);
         flag = true;
      }

      return flag;
   }

   public boolean renderBlockFence(BlockFence par1BlockFence, long par2, int par3, long par4) {
      boolean flag = false;
      float f = 0.375F;
      float f1 = 0.625F;
      par1BlockFence.a(f, 0.0F, f, f1, 1.0F, f1);
      this.renderStandardBlock(par1BlockFence, par2, par3, par4);
      flag = true;
      boolean flag1 = false;
      boolean flag2 = false;
      if (par1BlockFence.canConnectFenceTo(this.a, par2 - 1L, par3, par4) || par1BlockFence.canConnectFenceTo(this.a, par2 + 1L, par3, par4)) {
         flag1 = true;
      }

      if (par1BlockFence.canConnectFenceTo(this.a, par2, par3, par4 - 1L) || par1BlockFence.canConnectFenceTo(this.a, par2, par3, par4 + 1L)) {
         flag2 = true;
      }

      boolean flag3 = par1BlockFence.canConnectFenceTo(this.a, par2 - 1L, par3, par4);
      boolean flag4 = par1BlockFence.canConnectFenceTo(this.a, par2 + 1L, par3, par4);
      boolean flag5 = par1BlockFence.canConnectFenceTo(this.a, par2, par3, par4 - 1L);
      boolean flag6 = par1BlockFence.canConnectFenceTo(this.a, par2, par3, par4 + 1L);
      if (!flag1 && !flag2) {
         flag1 = true;
      }

      f = 0.4375F;
      f1 = 0.5625F;
      float f2 = 0.75F;
      float f3 = 0.9375F;
      float f4 = flag3 ? 0.0F : f;
      float f5 = flag4 ? 1.0F : f1;
      float f6 = flag5 ? 0.0F : f;
      float f7 = flag6 ? 1.0F : f1;
      if (flag1) {
         par1BlockFence.a(f4, f2, f, f5, f3, f1);
         this.renderStandardBlock(par1BlockFence, par2, par3, par4);
         flag = true;
      }

      if (flag2) {
         par1BlockFence.a(f, f2, f6, f1, f3, f7);
         this.renderStandardBlock(par1BlockFence, par2, par3, par4);
         flag = true;
      }

      f2 = 0.375F;
      f3 = 0.5625F;
      if (flag1) {
         par1BlockFence.a(f4, f2, f, f5, f3, f1);
         this.renderStandardBlock(par1BlockFence, par2, par3, par4);
         flag = true;
      }

      if (flag2) {
         par1BlockFence.a(f, f2, f6, f1, f3, f7);
         this.renderStandardBlock(par1BlockFence, par2, par3, par4);
         flag = true;
      }

      par1BlockFence.setBlockBoundsBasedOnState(this.a, par2, par3, par4);
      return flag;
   }

   public boolean renderBlockDragonEgg(BlockDragonEgg par1BlockDragonEgg, long par2, int par3, long par4) {
      boolean flag = false;
      int i = 0;

      for (int j = 0; j < 8; j++) {
         int k = 0;
         byte byte0 = 1;
         if (j == 0) {
            k = 2;
         }

         if (j == 1) {
            k = 3;
         }

         if (j == 2) {
            k = 4;
         }

         if (j == 3) {
            k = 5;
            byte0 = 2;
         }

         if (j == 4) {
            k = 6;
            byte0 = 3;
         }

         if (j == 5) {
            k = 7;
            byte0 = 5;
         }

         if (j == 6) {
            k = 6;
            byte0 = 2;
         }

         if (j == 7) {
            k = 3;
         }

         float f = k / 16.0F;
         float f1 = 1.0F - i / 16.0F;
         float f2 = 1.0F - (i + byte0) / 16.0F;
         i += byte0;
         par1BlockDragonEgg.a(0.5F - f, f2, 0.5F - f, 0.5F + f, f1, 0.5F + f);
         this.renderStandardBlock(par1BlockDragonEgg, par2, par3, par4);
      }

      flag = true;
      par1BlockDragonEgg.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      return flag;
   }

   public boolean renderBlockFenceGate(BlockFenceGate par1BlockFenceGate, long par2, int par3, long par4) {
      boolean flag = true;
      int i = this.a.getBlockMetadata(par2, par3, par4);
      boolean flag1 = BlockFenceGate.e(i);
      int j = w.a(i);
      if (j != 3 && j != 1) {
         float f1 = 0.0F;
         float f5 = 0.125F;
         float f9 = 0.4375F;
         float f13 = 0.5625F;
         par1BlockFenceGate.a(f1, 0.3125F, f9, f5, 1.0F, f13);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         f1 = 0.875F;
         f5 = 1.0F;
         par1BlockFenceGate.a(f1, 0.3125F, f9, f5, 1.0F, f13);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
      } else {
         float f = 0.4375F;
         float f4 = 0.5625F;
         float f8 = 0.0F;
         float f12 = 0.125F;
         par1BlockFenceGate.a(f, 0.3125F, f8, f4, 1.0F, f12);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         f8 = 0.875F;
         f12 = 1.0F;
         par1BlockFenceGate.a(f, 0.3125F, f8, f4, 1.0F, f12);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
      }

      if (!flag1) {
         if (j != 3 && j != 1) {
            float f3 = 0.375F;
            float f7 = 0.5F;
            float f11 = 0.4375F;
            float f15 = 0.5625F;
            par1BlockFenceGate.a(f3, 0.375F, f11, f7, 0.9375F, f15);
            this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
            f3 = 0.5F;
            f7 = 0.625F;
            par1BlockFenceGate.a(f3, 0.375F, f11, f7, 0.9375F, f15);
            this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
            f3 = 0.625F;
            f7 = 0.875F;
            par1BlockFenceGate.a(f3, 0.375F, f11, f7, 0.5625F, f15);
            this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
            par1BlockFenceGate.a(f3, 0.75F, f11, f7, 0.9375F, f15);
            this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
            f3 = 0.125F;
            f7 = 0.375F;
            par1BlockFenceGate.a(f3, 0.375F, f11, f7, 0.5625F, f15);
            this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
            par1BlockFenceGate.a(f3, 0.75F, f11, f7, 0.9375F, f15);
            this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         } else {
            float f2 = 0.4375F;
            float f6 = 0.5625F;
            float f10 = 0.375F;
            float f14 = 0.5F;
            par1BlockFenceGate.a(f2, 0.375F, f10, f6, 0.9375F, f14);
            this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
            f10 = 0.5F;
            f14 = 0.625F;
            par1BlockFenceGate.a(f2, 0.375F, f10, f6, 0.9375F, f14);
            this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
            f10 = 0.625F;
            f14 = 0.875F;
            par1BlockFenceGate.a(f2, 0.375F, f10, f6, 0.5625F, f14);
            this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
            par1BlockFenceGate.a(f2, 0.75F, f10, f6, 0.9375F, f14);
            this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
            f10 = 0.125F;
            f14 = 0.375F;
            par1BlockFenceGate.a(f2, 0.375F, f10, f6, 0.5625F, f14);
            this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
            par1BlockFenceGate.a(f2, 0.75F, f10, f6, 0.9375F, f14);
            this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         }
      } else if (j == 3) {
         par1BlockFenceGate.a(0.8125F, 0.375F, 0.0F, 0.9375F, 0.9375F, 0.125F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.8125F, 0.375F, 0.875F, 0.9375F, 0.9375F, 1.0F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.5625F, 0.375F, 0.0F, 0.8125F, 0.5625F, 0.125F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.5625F, 0.375F, 0.875F, 0.8125F, 0.5625F, 1.0F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.5625F, 0.75F, 0.0F, 0.8125F, 0.9375F, 0.125F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.5625F, 0.75F, 0.875F, 0.8125F, 0.9375F, 1.0F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
      } else if (j == 1) {
         par1BlockFenceGate.a(0.0625F, 0.375F, 0.0F, 0.1875F, 0.9375F, 0.125F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.0625F, 0.375F, 0.875F, 0.1875F, 0.9375F, 1.0F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.1875F, 0.375F, 0.0F, 0.4375F, 0.5625F, 0.125F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.1875F, 0.375F, 0.875F, 0.4375F, 0.5625F, 1.0F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.1875F, 0.75F, 0.0F, 0.4375F, 0.9375F, 0.125F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.1875F, 0.75F, 0.875F, 0.4375F, 0.9375F, 1.0F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
      } else if (j == 0) {
         par1BlockFenceGate.a(0.0F, 0.375F, 0.8125F, 0.125F, 0.9375F, 0.9375F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.875F, 0.375F, 0.8125F, 1.0F, 0.9375F, 0.9375F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.0F, 0.375F, 0.5625F, 0.125F, 0.5625F, 0.8125F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.875F, 0.375F, 0.5625F, 1.0F, 0.5625F, 0.8125F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.0F, 0.75F, 0.5625F, 0.125F, 0.9375F, 0.8125F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.875F, 0.75F, 0.5625F, 1.0F, 0.9375F, 0.8125F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
      } else if (j == 2) {
         par1BlockFenceGate.a(0.0F, 0.375F, 0.0625F, 0.125F, 0.9375F, 0.1875F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.875F, 0.375F, 0.0625F, 1.0F, 0.9375F, 0.1875F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.0F, 0.375F, 0.1875F, 0.125F, 0.5625F, 0.4375F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.875F, 0.375F, 0.1875F, 1.0F, 0.5625F, 0.4375F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.0F, 0.75F, 0.1875F, 0.125F, 0.9375F, 0.4375F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
         par1BlockFenceGate.a(0.875F, 0.75F, 0.1875F, 1.0F, 0.9375F, 0.4375F);
         this.renderStandardBlock(par1BlockFenceGate, par2, par3, par4);
      }

      par1BlockFenceGate.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      return flag;
   }

   public boolean renderBlockStairs(Block par1Block, long par2, int par3, long par4) {
      int i = this.a.getBlockMetadata(par2, par3, par4);
      int j = i & 3;
      float f = 0.0F;
      float f1 = 0.5F;
      float f2 = 0.5F;
      float f3 = 1.0F;
      if ((i & 4) != 0) {
         f = 0.5F;
         f1 = 1.0F;
         f2 = 0.0F;
         f3 = 0.5F;
      }

      par1Block.a(0.0F, f, 0.0F, 1.0F, f1, 1.0F);
      this.renderStandardBlock(par1Block, par2, par3, par4);
      if (j == 0) {
         par1Block.a(0.5F, f2, 0.0F, 1.0F, f3, 1.0F);
         this.renderStandardBlock(par1Block, par2, par3, par4);
      } else if (j == 1) {
         par1Block.a(0.0F, f2, 0.0F, 0.5F, f3, 1.0F);
         this.renderStandardBlock(par1Block, par2, par3, par4);
      } else if (j == 2) {
         par1Block.a(0.0F, f2, 0.5F, 1.0F, f3, 1.0F);
         this.renderStandardBlock(par1Block, par2, par3, par4);
      } else if (j == 3) {
         par1Block.a(0.0F, f2, 0.0F, 1.0F, f3, 0.5F);
         this.renderStandardBlock(par1Block, par2, par3, par4);
      }

      par1Block.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      return true;
   }

   public boolean renderBlockDoor(Block par1Block, long par2, int par3, long par4) {
      long par2a = par2 & 15L;
      int par3a = par3 & 15;
      long par4a = par4 & 15L;
      boolean useFix = stripeLandsFix && !this.isHitbox;
      Tessellator tessellator = Tessellator.a;
      BlockDoor blockdoor = (BlockDoor)par1Block;
      boolean flag = false;
      float f = 0.5F;
      float f1 = 1.0F;
      float f2 = 0.8F;
      float f3 = 0.6F;
      int i = par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4);
      tessellator.b(par1Block.bW <= 0.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3 - 1, par4) : i);
      tessellator.a(f, f, f);
      if (useFix) {
         this.renderBottomFace(par1Block, par2a, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 0), true);
      } else {
         this.a(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 0));
      }

      flag = true;
      tessellator.b(par1Block.bZ >= 1.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3 + 1, par4) : i);
      tessellator.a(f1, f1, f1);
      if (useFix) {
         this.renderTopFace(par1Block, par2a, par3a, par4a, par1Block.getBlockTexture(this.a, par2, par3, par4, 1), true);
      } else {
         this.b(par1Block, par2, par3, par4, par1Block.getBlockTexture(this.a, par2, par3, par4, 1));
      }

      flag = true;
      tessellator.b(par1Block.bX <= 0.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 - 1L) : i);
      tessellator.a(f2, f2, f2);
      int j = par1Block.getBlockTexture(this.a, par2, par3, par4, 2);
      if (j < 0) {
         this.e = true;
         j = -j;
      }

      if (useFix) {
         this.renderEastFace(par1Block, par2a, par3a, par4a, j, true);
      } else {
         this.c(par1Block, par2, par3, par4, j);
      }

      flag = true;
      this.e = false;
      tessellator.b(par1Block.IChunkProvider >= 1.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2, par3, par4 + 1L) : i);
      tessellator.a(f2, f2, f2);
      j = par1Block.getBlockTexture(this.a, par2, par3, par4, 3);
      if (j < 0) {
         this.e = true;
         j = -j;
      }

      if (useFix) {
         this.renderWestFace(par1Block, par2a, par3a, par4a, j, true);
      } else {
         this.d(par1Block, par2, par3, par4, j);
      }

      flag = true;
      this.e = false;
      tessellator.b(par1Block.bV <= 0.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2 - 1L, par3, par4) : i);
      tessellator.a(f3, f3, f3);
      j = par1Block.getBlockTexture(this.a, par2, par3, par4, 4);
      if (j < 0) {
         this.e = true;
         j = -j;
      }

      if (useFix) {
         this.renderNorthFace(par1Block, par2a, par3a, par4a, j, true);
      } else {
         this.e(par1Block, par2, par3, par4, j);
      }

      flag = true;
      this.e = false;
      tessellator.b(par1Block.bY >= 1.0 ? par1Block.getMixedBrightnessForBlock(this.a, par2 + 1L, par3, par4) : i);
      tessellator.a(f3, f3, f3);
      j = par1Block.getBlockTexture(this.a, par2, par3, par4, 5);
      if (j < 0) {
         this.e = true;
         j = -j;
      }

      if (useFix) {
         this.renderSouthFace(par1Block, par2a, par3a, par4a, j, true);
      } else {
         this.f(par1Block, par2, par3, par4, j);
      }

      flag = true;
      this.e = false;
      return flag;
   }

   public void a(Block par1Block, double par2, double par4, double par6, int par8) {
      this.renderBottomFace(par1Block, par2, par4, par6, par8, false);
   }

   public void renderBottomFace(Block par1Block, double par2, double par4, double par6, int par8, boolean fullBlock) {
      Tessellator tessellator = Tessellator.a;
      if (this.d >= 0) {
         par8 = this.d;
      }

      int i = (par8 & 15) << 4;
      int j = par8 & 240;
      double d = (i + par1Block.bV * 16.0) / 256.0;
      double d1 = (i + par1Block.bY * 16.0 - 0.01) / 256.0;
      double d2 = (j + par1Block.bX * 16.0) / 256.0;
      double d3 = (j + par1Block.IChunkProvider * 16.0 - 0.01) / 256.0;
      if (par1Block.bV < 0.0 || par1Block.bY > 1.0) {
         d = (i + 0.0F) / 256.0F;
         d1 = (i + 15.99F) / 256.0F;
      }

      if (par1Block.bX < 0.0 || par1Block.IChunkProvider > 1.0) {
         d2 = (j + 0.0F) / 256.0F;
         d3 = (j + 15.99F) / 256.0F;
      }

      double d4 = d1;
      double d5 = d;
      double d6 = d2;
      double d7 = d3;
      if (this.l == 2) {
         d = (i + par1Block.bX * 16.0) / 256.0;
         d2 = (j + 16 - par1Block.bY * 16.0) / 256.0;
         d1 = (i + par1Block.IChunkProvider * 16.0) / 256.0;
         d3 = (j + 16 - par1Block.bV * 16.0) / 256.0;
         d6 = d2;
         d7 = d3;
         d4 = d;
         d5 = d1;
         d2 = d3;
         d3 = d6;
      } else if (this.l == 1) {
         d = (i + 16 - par1Block.IChunkProvider * 16.0) / 256.0;
         d2 = (j + par1Block.bV * 16.0) / 256.0;
         d1 = (i + 16 - par1Block.bX * 16.0) / 256.0;
         d3 = (j + par1Block.bY * 16.0) / 256.0;
         d4 = d1;
         d5 = d;
         d = d4;
         d1 = d5;
         d6 = d3;
         d7 = d2;
      } else if (this.l == 3) {
         d = (i + 16 - par1Block.bV * 16.0) / 256.0;
         d1 = (i + 16 - par1Block.bY * 16.0 - 0.01) / 256.0;
         d2 = (j + 16 - par1Block.bX * 16.0) / 256.0;
         d3 = (j + 16 - par1Block.IChunkProvider * 16.0 - 0.01) / 256.0;
         d4 = d1;
         d5 = d;
         d6 = d2;
         d7 = d3;
      }

      double d8 = par2 + par1Block.bV;
      double d9 = par2 + par1Block.bY;
      double d10 = par4 + par1Block.bW;
      double d11 = par6 + par1Block.bX;
      double d12 = par6 + par1Block.IChunkProvider;
      if (this.m) {
         if (fullBlock) {
            tessellator.a(this.MapGenVillage, this.ar, this.EntityThrowable);
            tessellator.b(this.aj);
            tessellator.addVertexWithUVNoOffset(d8, d10, d12, d5, d7);
            tessellator.a(this.GenLayerHills, this.as, this.aw);
            tessellator.b(this.ak);
            tessellator.addVertexWithUVNoOffset(d8, d10, d11, d, d2);
            tessellator.a(this.ap, this.at, this.EntityAIAttackOnCollide);
            tessellator.b(this.BlockPortal);
            tessellator.addVertexWithUVNoOffset(d9, d10, d11, d4, d6);
            tessellator.a(this.aq, this.au, this.StructureNetherBridgeStart);
            tessellator.b(this.NoiseGeneratorPerlin);
            tessellator.addVertexWithUVNoOffset(d9, d10, d12, d1, d3);
         } else {
            tessellator.a(this.MapGenVillage, this.ar, this.EntityThrowable);
            tessellator.b(this.aj);
            tessellator.a(d8, d10, d12, d5, d7);
            tessellator.a(this.GenLayerHills, this.as, this.aw);
            tessellator.b(this.ak);
            tessellator.a(d8, d10, d11, d, d2);
            tessellator.a(this.ap, this.at, this.EntityAIAttackOnCollide);
            tessellator.b(this.BlockPortal);
            tessellator.a(d9, d10, d11, d4, d6);
            tessellator.a(this.aq, this.au, this.StructureNetherBridgeStart);
            tessellator.b(this.NoiseGeneratorPerlin);
            tessellator.a(d9, d10, d12, d1, d3);
         }
      } else if (fullBlock) {
         tessellator.addVertexWithUVNoOffset(d8, d10, d12, d5, d7);
         tessellator.addVertexWithUVNoOffset(d8, d10, d11, d, d2);
         tessellator.addVertexWithUVNoOffset(d9, d10, d11, d4, d6);
         tessellator.addVertexWithUVNoOffset(d9, d10, d12, d1, d3);
      } else {
         tessellator.a(d8, d10, d12, d5, d7);
         tessellator.a(d8, d10, d11, d, d2);
         tessellator.a(d9, d10, d11, d4, d6);
         tessellator.a(d9, d10, d12, d1, d3);
      }
   }

   public void b(Block par1Block, double par2, double par4, double par6, int par8) {
      this.renderTopFace(par1Block, par2, par4, par6, par8, false);
   }

   public void renderTopFace(Block par1Block, double par2, double par4, double par6, int par8, boolean fullBlock) {
      Tessellator tessellator = Tessellator.a;
      if (this.d >= 0) {
         par8 = this.d;
      }

      int i = (par8 & 15) << 4;
      int j = par8 & 240;
      double d = (i + par1Block.bV * 16.0) / 256.0;
      double d1 = (i + par1Block.bY * 16.0 - 0.01) / 256.0;
      double d2 = (j + par1Block.bX * 16.0) / 256.0;
      double d3 = (j + par1Block.IChunkProvider * 16.0 - 0.01) / 256.0;
      if (par1Block.bV < 0.0 || par1Block.bY > 1.0) {
         d = (i + 0.0F) / 256.0F;
         d1 = (i + 15.99F) / 256.0F;
      }

      if (par1Block.bX < 0.0 || par1Block.IChunkProvider > 1.0) {
         d2 = (j + 0.0F) / 256.0F;
         d3 = (j + 15.99F) / 256.0F;
      }

      double d4 = d1;
      double d5 = d;
      double d6 = d2;
      double d7 = d3;
      if (this.k == 1) {
         d = (i + par1Block.bX * 16.0) / 256.0;
         d2 = (j + 16 - par1Block.bY * 16.0) / 256.0;
         d1 = (i + par1Block.IChunkProvider * 16.0) / 256.0;
         d3 = (j + 16 - par1Block.bV * 16.0) / 256.0;
         d6 = d2;
         d7 = d3;
         d4 = d;
         d5 = d1;
         d2 = d3;
         d3 = d6;
      } else if (this.k == 2) {
         d = (i + 16 - par1Block.IChunkProvider * 16.0) / 256.0;
         d2 = (j + par1Block.bV * 16.0) / 256.0;
         d1 = (i + 16 - par1Block.bX * 16.0) / 256.0;
         d3 = (j + par1Block.bY * 16.0) / 256.0;
         d4 = d1;
         d5 = d;
         d = d4;
         d1 = d5;
         d6 = d3;
         d7 = d2;
      } else if (this.k == 3) {
         d = (i + 16 - par1Block.bV * 16.0) / 256.0;
         d1 = (i + 16 - par1Block.bY * 16.0 - 0.01) / 256.0;
         d2 = (j + 16 - par1Block.bX * 16.0) / 256.0;
         d3 = (j + 16 - par1Block.IChunkProvider * 16.0 - 0.01) / 256.0;
         d4 = d1;
         d5 = d;
         d6 = d2;
         d7 = d3;
      }

      double d8 = par2 + par1Block.bV;
      double d9 = par2 + par1Block.bY;
      double d10 = par4 + par1Block.bZ;
      double d11 = par6 + par1Block.bX;
      double d12 = par6 + par1Block.IChunkProvider;
      if (this.m) {
         if (fullBlock) {
            tessellator.a(this.MapGenVillage, this.ar, this.EntityThrowable);
            tessellator.b(this.aj);
            tessellator.addVertexWithUVNoOffset(d9, d10, d12, d1, d3);
            tessellator.a(this.GenLayerHills, this.as, this.aw);
            tessellator.b(this.ak);
            tessellator.addVertexWithUVNoOffset(d9, d10, d11, d4, d6);
            tessellator.a(this.ap, this.at, this.EntityAIAttackOnCollide);
            tessellator.b(this.BlockPortal);
            tessellator.addVertexWithUVNoOffset(d8, d10, d11, d, d2);
            tessellator.a(this.aq, this.au, this.StructureNetherBridgeStart);
            tessellator.b(this.NoiseGeneratorPerlin);
            tessellator.addVertexWithUVNoOffset(d8, d10, d12, d5, d7);
         } else {
            tessellator.a(this.MapGenVillage, this.ar, this.EntityThrowable);
            tessellator.b(this.aj);
            tessellator.a(d9, d10, d12, d1, d3);
            tessellator.a(this.GenLayerHills, this.as, this.aw);
            tessellator.b(this.ak);
            tessellator.a(d9, d10, d11, d4, d6);
            tessellator.a(this.ap, this.at, this.EntityAIAttackOnCollide);
            tessellator.b(this.BlockPortal);
            tessellator.a(d8, d10, d11, d, d2);
            tessellator.a(this.aq, this.au, this.StructureNetherBridgeStart);
            tessellator.b(this.NoiseGeneratorPerlin);
            tessellator.a(d8, d10, d12, d5, d7);
         }
      } else if (fullBlock) {
         tessellator.addVertexWithUVNoOffset(d9, d10, d12, d1, d3);
         tessellator.addVertexWithUVNoOffset(d9, d10, d11, d4, d6);
         tessellator.addVertexWithUVNoOffset(d8, d10, d11, d, d2);
         tessellator.addVertexWithUVNoOffset(d8, d10, d12, d5, d7);
      } else {
         tessellator.a(d9, d10, d12, d1, d3);
         tessellator.a(d9, d10, d11, d4, d6);
         tessellator.a(d8, d10, d11, d, d2);
         tessellator.a(d8, d10, d12, d5, d7);
      }
   }

   public void c(Block par1Block, double par2, double par4, double par6, int par8) {
      this.renderEastFace(par1Block, par2, par4, par6, par8, false);
   }

   public void renderEastFace(Block par1Block, double par2, double par4, double par6, int par8, boolean fullBlock) {
      Tessellator tessellator = Tessellator.a;
      if (this.d >= 0) {
         par8 = this.d;
      }

      int i = (par8 & 15) << 4;
      int j = par8 & 240;
      double d = (i + par1Block.bV * 16.0) / 256.0;
      double d1 = (i + par1Block.bY * 16.0 - 0.01) / 256.0;
      double d2 = (j + 16 - par1Block.bZ * 16.0) / 256.0;
      double d3 = (j + 16 - par1Block.bW * 16.0 - 0.01) / 256.0;
      if (this.e) {
         double d4 = d;
         d = d1;
         d1 = d4;
      }

      if (par1Block.bV < 0.0 || par1Block.bY > 1.0) {
         d = (i + 0.0F) / 256.0F;
         d1 = (i + 15.99F) / 256.0F;
      }

      if (par1Block.bW < 0.0 || par1Block.bZ > 1.0) {
         d2 = (j + 0.0F) / 256.0F;
         d3 = (j + 15.99F) / 256.0F;
      }

      double d5 = d1;
      double d6 = d;
      double d7 = d2;
      double d8 = d3;
      if (this.g == 2) {
         d = (i + par1Block.bW * 16.0) / 256.0;
         d2 = (j + 16 - par1Block.bV * 16.0) / 256.0;
         d1 = (i + par1Block.bZ * 16.0) / 256.0;
         d3 = (j + 16 - par1Block.bY * 16.0) / 256.0;
         d7 = d2;
         d8 = d3;
         d5 = d;
         d6 = d1;
         d2 = d3;
         d3 = d7;
      } else if (this.g == 1) {
         d = (i + 16 - par1Block.bZ * 16.0) / 256.0;
         d2 = (j + par1Block.bY * 16.0) / 256.0;
         d1 = (i + 16 - par1Block.bW * 16.0) / 256.0;
         d3 = (j + par1Block.bV * 16.0) / 256.0;
         d5 = d1;
         d6 = d;
         d = d5;
         d1 = d6;
         d7 = d3;
         d8 = d2;
      } else if (this.g == 3) {
         d = (i + 16 - par1Block.bV * 16.0) / 256.0;
         d1 = (i + 16 - par1Block.bY * 16.0 - 0.01) / 256.0;
         d2 = (j + par1Block.bZ * 16.0) / 256.0;
         d3 = (j + par1Block.bW * 16.0 - 0.01) / 256.0;
         d5 = d1;
         d6 = d;
         d7 = d2;
         d8 = d3;
      }

      double d9 = par2 + par1Block.bV;
      double d10 = par2 + par1Block.bY;
      double d11 = par4 + par1Block.bW;
      double d12 = par4 + par1Block.bZ;
      double d13 = par6 + par1Block.bX;
      if (this.m) {
         if (fullBlock) {
            tessellator.a(this.MapGenVillage, this.ar, this.EntityThrowable);
            tessellator.b(this.aj);
            tessellator.addVertexWithUVNoOffset(d9, d12, d13, d5, d7);
            tessellator.a(this.GenLayerHills, this.as, this.aw);
            tessellator.b(this.ak);
            tessellator.addVertexWithUVNoOffset(d10, d12, d13, d, d2);
            tessellator.a(this.ap, this.at, this.EntityAIAttackOnCollide);
            tessellator.b(this.BlockPortal);
            tessellator.addVertexWithUVNoOffset(d10, d11, d13, d6, d8);
            tessellator.a(this.aq, this.au, this.StructureNetherBridgeStart);
            tessellator.b(this.NoiseGeneratorPerlin);
            tessellator.addVertexWithUVNoOffset(d9, d11, d13, d1, d3);
         } else {
            tessellator.a(this.MapGenVillage, this.ar, this.EntityThrowable);
            tessellator.b(this.aj);
            tessellator.a(d9, d12, d13, d5, d7);
            tessellator.a(this.GenLayerHills, this.as, this.aw);
            tessellator.b(this.ak);
            tessellator.a(d10, d12, d13, d, d2);
            tessellator.a(this.ap, this.at, this.EntityAIAttackOnCollide);
            tessellator.b(this.BlockPortal);
            tessellator.a(d10, d11, d13, d6, d8);
            tessellator.a(this.aq, this.au, this.StructureNetherBridgeStart);
            tessellator.b(this.NoiseGeneratorPerlin);
            tessellator.a(d9, d11, d13, d1, d3);
         }
      } else if (fullBlock) {
         tessellator.addVertexWithUVNoOffset(d9, d12, d13, d5, d7);
         tessellator.addVertexWithUVNoOffset(d10, d12, d13, d, d2);
         tessellator.addVertexWithUVNoOffset(d10, d11, d13, d6, d8);
         tessellator.addVertexWithUVNoOffset(d9, d11, d13, d1, d3);
      } else {
         tessellator.a(d9, d12, d13, d5, d7);
         tessellator.a(d10, d12, d13, d, d2);
         tessellator.a(d10, d11, d13, d6, d8);
         tessellator.a(d9, d11, d13, d1, d3);
      }
   }

   public void d(Block par1Block, double par2, double par4, double par6, int par8) {
      this.renderWestFace(par1Block, par2, par4, par6, par8, false);
   }

   public void renderWestFace(Block par1Block, double par2, double par4, double par6, int par8, boolean fullBlock) {
      Tessellator tessellator = Tessellator.a;
      if (this.d >= 0) {
         par8 = this.d;
      }

      int i = (par8 & 15) << 4;
      int j = par8 & 240;
      double d = (i + par1Block.bV * 16.0) / 256.0;
      double d1 = (i + par1Block.bY * 16.0 - 0.01) / 256.0;
      double d2 = (j + 16 - par1Block.bZ * 16.0) / 256.0;
      double d3 = (j + 16 - par1Block.bW * 16.0 - 0.01) / 256.0;
      if (this.e) {
         double d4 = d;
         d = d1;
         d1 = d4;
      }

      if (par1Block.bV < 0.0 || par1Block.bY > 1.0) {
         d = (i + 0.0F) / 256.0F;
         d1 = (i + 15.99F) / 256.0F;
      }

      if (par1Block.bW < 0.0 || par1Block.bZ > 1.0) {
         d2 = (j + 0.0F) / 256.0F;
         d3 = (j + 15.99F) / 256.0F;
      }

      double d5 = d1;
      double d6 = d;
      double d7 = d2;
      double d8 = d3;
      if (this.h == 1) {
         d = (i + par1Block.bW * 16.0) / 256.0;
         d3 = (j + 16 - par1Block.bV * 16.0) / 256.0;
         d1 = (i + par1Block.bZ * 16.0) / 256.0;
         d2 = (j + 16 - par1Block.bY * 16.0) / 256.0;
         d7 = d2;
         d8 = d3;
         d5 = d;
         d6 = d1;
         d2 = d3;
         d3 = d7;
      } else if (this.h == 2) {
         d = (i + 16 - par1Block.bZ * 16.0) / 256.0;
         d2 = (j + par1Block.bV * 16.0) / 256.0;
         d1 = (i + 16 - par1Block.bW * 16.0) / 256.0;
         d3 = (j + par1Block.bY * 16.0) / 256.0;
         d5 = d1;
         d6 = d;
         d = d5;
         d1 = d6;
         d7 = d3;
         d8 = d2;
      } else if (this.h == 3) {
         d = (i + 16 - par1Block.bV * 16.0) / 256.0;
         d1 = (i + 16 - par1Block.bY * 16.0 - 0.01) / 256.0;
         d2 = (j + par1Block.bZ * 16.0) / 256.0;
         d3 = (j + par1Block.bW * 16.0 - 0.01) / 256.0;
         d5 = d1;
         d6 = d;
         d7 = d2;
         d8 = d3;
      }

      double d9 = par2 + par1Block.bV;
      double d10 = par2 + par1Block.bY;
      double d11 = par4 + par1Block.bW;
      double d12 = par4 + par1Block.bZ;
      double d13 = par6 + par1Block.IChunkProvider;
      if (this.m) {
         if (fullBlock) {
            tessellator.a(this.MapGenVillage, this.ar, this.EntityThrowable);
            tessellator.b(this.aj);
            tessellator.addVertexWithUVNoOffset(d9, d12, d13, d, d2);
            tessellator.a(this.GenLayerHills, this.as, this.aw);
            tessellator.b(this.ak);
            tessellator.addVertexWithUVNoOffset(d9, d11, d13, d6, d8);
            tessellator.a(this.ap, this.at, this.EntityAIAttackOnCollide);
            tessellator.b(this.BlockPortal);
            tessellator.addVertexWithUVNoOffset(d10, d11, d13, d1, d3);
            tessellator.a(this.aq, this.au, this.StructureNetherBridgeStart);
            tessellator.b(this.NoiseGeneratorPerlin);
            tessellator.addVertexWithUVNoOffset(d10, d12, d13, d5, d7);
         } else {
            tessellator.a(this.MapGenVillage, this.ar, this.EntityThrowable);
            tessellator.b(this.aj);
            tessellator.a(d9, d12, d13, d, d2);
            tessellator.a(this.GenLayerHills, this.as, this.aw);
            tessellator.b(this.ak);
            tessellator.a(d9, d11, d13, d6, d8);
            tessellator.a(this.ap, this.at, this.EntityAIAttackOnCollide);
            tessellator.b(this.BlockPortal);
            tessellator.a(d10, d11, d13, d1, d3);
            tessellator.a(this.aq, this.au, this.StructureNetherBridgeStart);
            tessellator.b(this.NoiseGeneratorPerlin);
            tessellator.a(d10, d12, d13, d5, d7);
         }
      } else if (fullBlock) {
         tessellator.addVertexWithUVNoOffset(d9, d12, d13, d, d2);
         tessellator.addVertexWithUVNoOffset(d9, d11, d13, d6, d8);
         tessellator.addVertexWithUVNoOffset(d10, d11, d13, d1, d3);
         tessellator.addVertexWithUVNoOffset(d10, d12, d13, d5, d7);
      } else {
         tessellator.a(d9, d12, d13, d, d2);
         tessellator.a(d9, d11, d13, d6, d8);
         tessellator.a(d10, d11, d13, d1, d3);
         tessellator.a(d10, d12, d13, d5, d7);
      }
   }

   public void e(Block par1Block, double par2, double par4, double par6, int par8) {
      this.renderNorthFace(par1Block, par2, par4, par6, par8, false);
   }

   public void renderNorthFace(Block par1Block, double par2, double par4, double par6, int par8, boolean fullBlock) {
      Tessellator tessellator = Tessellator.a;
      if (this.d >= 0) {
         par8 = this.d;
      }

      int i = (par8 & 15) << 4;
      int j = par8 & 240;
      double d = (i + par1Block.bX * 16.0) / 256.0;
      double d1 = (i + par1Block.IChunkProvider * 16.0 - 0.01) / 256.0;
      double d2 = (j + 16 - par1Block.bZ * 16.0) / 256.0;
      double d3 = (j + 16 - par1Block.bW * 16.0 - 0.01) / 256.0;
      if (this.e) {
         double d4 = d;
         d = d1;
         d1 = d4;
      }

      if (par1Block.bX < 0.0 || par1Block.IChunkProvider > 1.0) {
         d = (i + 0.0F) / 256.0F;
         d1 = (i + 15.99F) / 256.0F;
      }

      if (par1Block.bW < 0.0 || par1Block.bZ > 1.0) {
         d2 = (j + 0.0F) / 256.0F;
         d3 = (j + 15.99F) / 256.0F;
      }

      double d5 = d1;
      double d6 = d;
      double d7 = d2;
      double d8 = d3;
      if (this.j == 1) {
         d = (i + par1Block.bW * 16.0) / 256.0;
         d2 = (j + 16 - par1Block.IChunkProvider * 16.0) / 256.0;
         d1 = (i + par1Block.bZ * 16.0) / 256.0;
         d3 = (j + 16 - par1Block.bX * 16.0) / 256.0;
         d7 = d2;
         d8 = d3;
         d5 = d;
         d6 = d1;
         d2 = d3;
         d3 = d7;
      } else if (this.j == 2) {
         d = (i + 16 - par1Block.bZ * 16.0) / 256.0;
         d2 = (j + par1Block.bX * 16.0) / 256.0;
         d1 = (i + 16 - par1Block.bW * 16.0) / 256.0;
         d3 = (j + par1Block.IChunkProvider * 16.0) / 256.0;
         d5 = d1;
         d6 = d;
         d = d5;
         d1 = d6;
         d7 = d3;
         d8 = d2;
      } else if (this.j == 3) {
         d = (i + 16 - par1Block.bX * 16.0) / 256.0;
         d1 = (i + 16 - par1Block.IChunkProvider * 16.0 - 0.01) / 256.0;
         d2 = (j + par1Block.bZ * 16.0) / 256.0;
         d3 = (j + par1Block.bW * 16.0 - 0.01) / 256.0;
         d5 = d1;
         d6 = d;
         d7 = d2;
         d8 = d3;
      }

      double d9 = par2 + par1Block.bV;
      double d10 = par4 + par1Block.bW;
      double d11 = par4 + par1Block.bZ;
      double d12 = par6 + par1Block.bX;
      double d13 = par6 + par1Block.IChunkProvider;
      if (this.m) {
         if (fullBlock) {
            tessellator.a(this.MapGenVillage, this.ar, this.EntityThrowable);
            tessellator.b(this.aj);
            tessellator.addVertexWithUVNoOffset(d9, d11, d13, d5, d7);
            tessellator.a(this.GenLayerHills, this.as, this.aw);
            tessellator.b(this.ak);
            tessellator.addVertexWithUVNoOffset(d9, d11, d12, d, d2);
            tessellator.a(this.ap, this.at, this.EntityAIAttackOnCollide);
            tessellator.b(this.BlockPortal);
            tessellator.addVertexWithUVNoOffset(d9, d10, d12, d6, d8);
            tessellator.a(this.aq, this.au, this.StructureNetherBridgeStart);
            tessellator.b(this.NoiseGeneratorPerlin);
            tessellator.addVertexWithUVNoOffset(d9, d10, d13, d1, d3);
         } else {
            tessellator.a(this.MapGenVillage, this.ar, this.EntityThrowable);
            tessellator.b(this.aj);
            tessellator.a(d9, d11, d13, d5, d7);
            tessellator.a(this.GenLayerHills, this.as, this.aw);
            tessellator.b(this.ak);
            tessellator.a(d9, d11, d12, d, d2);
            tessellator.a(this.ap, this.at, this.EntityAIAttackOnCollide);
            tessellator.b(this.BlockPortal);
            tessellator.a(d9, d10, d12, d6, d8);
            tessellator.a(this.aq, this.au, this.StructureNetherBridgeStart);
            tessellator.b(this.NoiseGeneratorPerlin);
            tessellator.a(d9, d10, d13, d1, d3);
         }
      } else if (fullBlock) {
         tessellator.addVertexWithUVNoOffset(d9, d11, d13, d5, d7);
         tessellator.addVertexWithUVNoOffset(d9, d11, d12, d, d2);
         tessellator.addVertexWithUVNoOffset(d9, d10, d12, d6, d8);
         tessellator.addVertexWithUVNoOffset(d9, d10, d13, d1, d3);
      } else {
         tessellator.a(d9, d11, d13, d5, d7);
         tessellator.a(d9, d11, d12, d, d2);
         tessellator.a(d9, d10, d12, d6, d8);
         tessellator.a(d9, d10, d13, d1, d3);
      }
   }

   public void f(Block par1Block, double par2, double par4, double par6, int par8) {
      this.renderSouthFace(par1Block, par2, par4, par6, par8, false);
   }

   public void renderSouthFace(Block par1Block, double par2, double par4, double par6, int par8, boolean fullBlock) {
      Tessellator tessellator = Tessellator.a;
      if (this.d >= 0) {
         par8 = this.d;
      }

      int i = (par8 & 15) << 4;
      int j = par8 & 240;
      double d = (i + par1Block.bX * 16.0) / 256.0;
      double d1 = (i + par1Block.IChunkProvider * 16.0 - 0.01) / 256.0;
      double d2 = (j + 16 - par1Block.bZ * 16.0) / 256.0;
      double d3 = (j + 16 - par1Block.bW * 16.0 - 0.01) / 256.0;
      if (this.e) {
         double d4 = d;
         d = d1;
         d1 = d4;
      }

      if (par1Block.bX < 0.0 || par1Block.IChunkProvider > 1.0) {
         d = (i + 0.0F) / 256.0F;
         d1 = (i + 15.99F) / 256.0F;
      }

      if (par1Block.bW < 0.0 || par1Block.bZ > 1.0) {
         d2 = (j + 0.0F) / 256.0F;
         d3 = (j + 15.99F) / 256.0F;
      }

      double d5 = d1;
      double d6 = d;
      double d7 = d2;
      double d8 = d3;
      if (this.i == 2) {
         d = (i + par1Block.bW * 16.0) / 256.0;
         d2 = (j + 16 - par1Block.bX * 16.0) / 256.0;
         d1 = (i + par1Block.bZ * 16.0) / 256.0;
         d3 = (j + 16 - par1Block.IChunkProvider * 16.0) / 256.0;
         d7 = d2;
         d8 = d3;
         d5 = d;
         d6 = d1;
         d2 = d3;
         d3 = d7;
      } else if (this.i == 1) {
         d = (i + 16 - par1Block.bZ * 16.0) / 256.0;
         d2 = (j + par1Block.IChunkProvider * 16.0) / 256.0;
         d1 = (i + 16 - par1Block.bW * 16.0) / 256.0;
         d3 = (j + par1Block.bX * 16.0) / 256.0;
         d5 = d1;
         d6 = d;
         d = d5;
         d1 = d6;
         d7 = d3;
         d8 = d2;
      } else if (this.i == 3) {
         d = (i + 16 - par1Block.bX * 16.0) / 256.0;
         d1 = (i + 16 - par1Block.IChunkProvider * 16.0 - 0.01) / 256.0;
         d2 = (j + par1Block.bZ * 16.0) / 256.0;
         d3 = (j + par1Block.bW * 16.0 - 0.01) / 256.0;
         d5 = d1;
         d6 = d;
         d7 = d2;
         d8 = d3;
      }

      double d9 = par2 + par1Block.bY;
      double d10 = par4 + par1Block.bW;
      double d11 = par4 + par1Block.bZ;
      double d12 = par6 + par1Block.bX;
      double d13 = par6 + par1Block.IChunkProvider;
      if (this.m) {
         if (fullBlock) {
            tessellator.a(this.MapGenVillage, this.ar, this.EntityThrowable);
            tessellator.b(this.aj);
            tessellator.addVertexWithUVNoOffset(d9, d10, d13, d6, d8);
            tessellator.a(this.GenLayerHills, this.as, this.aw);
            tessellator.b(this.ak);
            tessellator.addVertexWithUVNoOffset(d9, d10, d12, d1, d3);
            tessellator.a(this.ap, this.at, this.EntityAIAttackOnCollide);
            tessellator.b(this.BlockPortal);
            tessellator.addVertexWithUVNoOffset(d9, d11, d12, d5, d7);
            tessellator.a(this.aq, this.au, this.StructureNetherBridgeStart);
            tessellator.b(this.NoiseGeneratorPerlin);
            tessellator.addVertexWithUVNoOffset(d9, d11, d13, d, d2);
         } else {
            tessellator.a(this.MapGenVillage, this.ar, this.EntityThrowable);
            tessellator.b(this.aj);
            tessellator.a(d9, d10, d13, d6, d8);
            tessellator.a(this.GenLayerHills, this.as, this.aw);
            tessellator.b(this.ak);
            tessellator.a(d9, d10, d12, d1, d3);
            tessellator.a(this.ap, this.at, this.EntityAIAttackOnCollide);
            tessellator.b(this.BlockPortal);
            tessellator.a(d9, d11, d12, d5, d7);
            tessellator.a(this.aq, this.au, this.StructureNetherBridgeStart);
            tessellator.b(this.NoiseGeneratorPerlin);
            tessellator.a(d9, d11, d13, d, d2);
         }
      } else if (fullBlock) {
         tessellator.addVertexWithUVNoOffset(d9, d10, d13, d6, d8);
         tessellator.addVertexWithUVNoOffset(d9, d10, d12, d1, d3);
         tessellator.addVertexWithUVNoOffset(d9, d11, d12, d5, d7);
         tessellator.addVertexWithUVNoOffset(d9, d11, d13, d, d2);
      } else {
         tessellator.a(d9, d10, d13, d6, d8);
         tessellator.a(d9, d10, d12, d1, d3);
         tessellator.a(d9, d11, d12, d5, d7);
         tessellator.a(d9, d11, d13, d, d2);
      }
   }

   public void a(Block par1Block, int par2, float par3) {
      Tessellator tessellator = Tessellator.a;
      boolean flag = par1Block.bO == Block.u.bO;
      if (this.c) {
         int i = par1Block.d(par2);
         if (flag) {
            i = 16777215;
         }

         float f = (i >> 16 & 0xFF) / 255.0F;
         float f2 = (i >> 8 & 0xFF) / 255.0F;
         float f6 = (i & 0xFF) / 255.0F;
         GL11.glColor4f(f * par3, f2 * par3, f6 * par3, 1.0F);
      }

      int j = par1Block.d();
      if (j != 0 && j != 16 && j != 26) {
         if (j == 1) {
            tessellator.b();
            tessellator.b(0.0F, -1.0F, 0.0F);
            this.a(par1Block, par2, -0.5, -0.5, -0.5);
            tessellator.a();
         } else if (j == 19) {
            tessellator.b();
            tessellator.b(0.0F, -1.0F, 0.0F);
            par1Block.h();
            this.a(par1Block, par2, par1Block.bZ, -0.5, -0.5, -0.5);
            tessellator.a();
         } else if (j == 23) {
            tessellator.b();
            tessellator.b(0.0F, -1.0F, 0.0F);
            par1Block.h();
            tessellator.a();
         } else if (j == 13) {
            par1Block.h();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float f1 = 0.0625F;
            tessellator.b();
            tessellator.b(0.0F, -1.0F, 0.0F);
            this.a(par1Block, 0.0, 0.0, 0.0, par1Block.a_(0));
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0F, 1.0F, 0.0F);
            this.b(par1Block, 0.0, 0.0, 0.0, par1Block.a_(1));
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0F, 0.0F, -1.0F);
            tessellator.c(0.0F, 0.0F, f1);
            this.c(par1Block, 0.0, 0.0, 0.0, par1Block.a_(2));
            tessellator.c(0.0F, 0.0F, -f1);
            tessellator.a();
            tessellator.b();
            tessellator.b(0.0F, 0.0F, 1.0F);
            tessellator.c(0.0F, 0.0F, -f1);
            this.d(par1Block, 0.0, 0.0, 0.0, par1Block.a_(3));
            tessellator.c(0.0F, 0.0F, f1);
            tessellator.a();
            tessellator.b();
            tessellator.b(-1.0F, 0.0F, 0.0F);
            tessellator.c(f1, 0.0F, 0.0F);
            this.e(par1Block, 0.0, 0.0, 0.0, par1Block.a_(4));
            tessellator.c(-f1, 0.0F, 0.0F);
            tessellator.a();
            tessellator.b();
            tessellator.b(1.0F, 0.0F, 0.0F);
            tessellator.c(-f1, 0.0F, 0.0F);
            this.f(par1Block, 0.0, 0.0, 0.0, par1Block.a_(5));
            tessellator.c(f1, 0.0F, 0.0F);
            tessellator.a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
         } else if (j == 22) {
            ChestItemRenderHelper.a.a(par1Block, par2, par3);
            GL11.glEnable(32826);
         } else if (j == 6) {
            tessellator.b();
            tessellator.b(0.0F, -1.0F, 0.0F);
            this.b(par1Block, par2, -0.5, -0.5, -0.5);
            tessellator.a();
         } else if (j == 2) {
            tessellator.b();
            tessellator.b(0.0F, -1.0F, 0.0F);
            this.a(par1Block, -0.5, -0.5, -0.5, 0.0, 0.0);
            tessellator.a();
         } else if (j == 10) {
            for (int l = 0; l < 2; l++) {
               if (l == 0) {
                  par1Block.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
               }

               if (l == 1) {
                  par1Block.a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               tessellator.b();
               tessellator.b(0.0F, -1.0F, 0.0F);
               this.a(par1Block, 0.0, 0.0, 0.0, par1Block.a_(0));
               tessellator.a();
               tessellator.b();
               tessellator.b(0.0F, 1.0F, 0.0F);
               this.b(par1Block, 0.0, 0.0, 0.0, par1Block.a_(1));
               tessellator.a();
               tessellator.b();
               tessellator.b(0.0F, 0.0F, -1.0F);
               this.c(par1Block, 0.0, 0.0, 0.0, par1Block.a_(2));
               tessellator.a();
               tessellator.b();
               tessellator.b(0.0F, 0.0F, 1.0F);
               this.d(par1Block, 0.0, 0.0, 0.0, par1Block.a_(3));
               tessellator.a();
               tessellator.b();
               tessellator.b(-1.0F, 0.0F, 0.0F);
               this.e(par1Block, 0.0, 0.0, 0.0, par1Block.a_(4));
               tessellator.a();
               tessellator.b();
               tessellator.b(1.0F, 0.0F, 0.0F);
               this.f(par1Block, 0.0, 0.0, 0.0, par1Block.a_(5));
               tessellator.a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }
         } else if (j == 27) {
            int i1 = 0;
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            tessellator.b();

            for (int l1 = 0; l1 < 8; l1++) {
               int i2 = 0;
               byte byte0 = 1;
               if (l1 == 0) {
                  i2 = 2;
               }

               if (l1 == 1) {
                  i2 = 3;
               }

               if (l1 == 2) {
                  i2 = 4;
               }

               if (l1 == 3) {
                  i2 = 5;
                  byte0 = 2;
               }

               if (l1 == 4) {
                  i2 = 6;
                  byte0 = 3;
               }

               if (l1 == 5) {
                  i2 = 7;
                  byte0 = 5;
               }

               if (l1 == 6) {
                  i2 = 6;
                  byte0 = 2;
               }

               if (l1 == 7) {
                  i2 = 3;
               }

               float f9 = i2 / 16.0F;
               float f10 = 1.0F - i1 / 16.0F;
               float f11 = 1.0F - (i1 + byte0) / 16.0F;
               i1 += byte0;
               par1Block.a(0.5F - f9, f11, 0.5F - f9, 0.5F + f9, f10, 0.5F + f9);
               tessellator.b(0.0F, -1.0F, 0.0F);
               this.a(par1Block, 0.0, 0.0, 0.0, par1Block.a_(0));
               tessellator.b(0.0F, 1.0F, 0.0F);
               this.b(par1Block, 0.0, 0.0, 0.0, par1Block.a_(1));
               tessellator.b(0.0F, 0.0F, -1.0F);
               this.c(par1Block, 0.0, 0.0, 0.0, par1Block.a_(2));
               tessellator.b(0.0F, 0.0F, 1.0F);
               this.d(par1Block, 0.0, 0.0, 0.0, par1Block.a_(3));
               tessellator.b(-1.0F, 0.0F, 0.0F);
               this.e(par1Block, 0.0, 0.0, 0.0, par1Block.a_(4));
               tessellator.b(1.0F, 0.0F, 0.0F);
               this.f(par1Block, 0.0, 0.0, 0.0, par1Block.a_(5));
            }

            tessellator.a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            par1Block.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else if (j == 11) {
            for (int j1 = 0; j1 < 4; j1++) {
               float f4 = 0.125F;
               if (j1 == 0) {
                  par1Block.a(0.5F - f4, 0.0F, 0.0F, 0.5F + f4, 1.0F, f4 * 2.0F);
               }

               if (j1 == 1) {
                  par1Block.a(0.5F - f4, 0.0F, 1.0F - f4 * 2.0F, 0.5F + f4, 1.0F, 1.0F);
               }

               f4 = 0.0625F;
               if (j1 == 2) {
                  par1Block.a(0.5F - f4, 1.0F - f4 * 3.0F, -f4 * 2.0F, 0.5F + f4, 1.0F - f4, 1.0F + f4 * 2.0F);
               }

               if (j1 == 3) {
                  par1Block.a(0.5F - f4, 0.5F - f4 * 3.0F, -f4 * 2.0F, 0.5F + f4, 0.5F - f4, 1.0F + f4 * 2.0F);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               tessellator.b();
               tessellator.b(0.0F, -1.0F, 0.0F);
               this.a(par1Block, 0.0, 0.0, 0.0, par1Block.a_(0));
               tessellator.a();
               tessellator.b();
               tessellator.b(0.0F, 1.0F, 0.0F);
               this.b(par1Block, 0.0, 0.0, 0.0, par1Block.a_(1));
               tessellator.a();
               tessellator.b();
               tessellator.b(0.0F, 0.0F, -1.0F);
               this.c(par1Block, 0.0, 0.0, 0.0, par1Block.a_(2));
               tessellator.a();
               tessellator.b();
               tessellator.b(0.0F, 0.0F, 1.0F);
               this.d(par1Block, 0.0, 0.0, 0.0, par1Block.a_(3));
               tessellator.a();
               tessellator.b();
               tessellator.b(-1.0F, 0.0F, 0.0F);
               this.e(par1Block, 0.0, 0.0, 0.0, par1Block.a_(4));
               tessellator.a();
               tessellator.b();
               tessellator.b(1.0F, 0.0F, 0.0F);
               this.f(par1Block, 0.0, 0.0, 0.0, par1Block.a_(5));
               tessellator.a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            par1Block.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else if (j == 21) {
            for (int k1 = 0; k1 < 3; k1++) {
               float f5 = 0.0625F;
               if (k1 == 0) {
                  par1Block.a(0.5F - f5, 0.3F, 0.0F, 0.5F + f5, 1.0F, f5 * 2.0F);
               }

               if (k1 == 1) {
                  par1Block.a(0.5F - f5, 0.3F, 1.0F - f5 * 2.0F, 0.5F + f5, 1.0F, 1.0F);
               }

               f5 = 0.0625F;
               if (k1 == 2) {
                  par1Block.a(0.5F - f5, 0.5F, 0.0F, 0.5F + f5, 1.0F - f5, 1.0F);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               tessellator.b();
               tessellator.b(0.0F, -1.0F, 0.0F);
               this.a(par1Block, 0.0, 0.0, 0.0, par1Block.a_(0));
               tessellator.a();
               tessellator.b();
               tessellator.b(0.0F, 1.0F, 0.0F);
               this.b(par1Block, 0.0, 0.0, 0.0, par1Block.a_(1));
               tessellator.a();
               tessellator.b();
               tessellator.b(0.0F, 0.0F, -1.0F);
               this.c(par1Block, 0.0, 0.0, 0.0, par1Block.a_(2));
               tessellator.a();
               tessellator.b();
               tessellator.b(0.0F, 0.0F, 1.0F);
               this.d(par1Block, 0.0, 0.0, 0.0, par1Block.a_(3));
               tessellator.a();
               tessellator.b();
               tessellator.b(-1.0F, 0.0F, 0.0F);
               this.e(par1Block, 0.0, 0.0, 0.0, par1Block.a_(4));
               tessellator.a();
               tessellator.b();
               tessellator.b(1.0F, 0.0F, 0.0F);
               this.f(par1Block, 0.0, 0.0, 0.0, par1Block.a_(5));
               tessellator.a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            par1Block.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         }
      } else {
         if (j == 16) {
            par2 = 1;
         }

         par1Block.h();
         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
         tessellator.b();
         tessellator.b(0.0F, -1.0F, 0.0F);
         this.a(par1Block, 0.0, 0.0, 0.0, par1Block.a(0, par2));
         tessellator.a();
         if (flag && this.c) {
            int k = par1Block.d(par2);
            float f3 = (k >> 16 & 0xFF) / 255.0F;
            float f7 = (k >> 8 & 0xFF) / 255.0F;
            float f8 = (k & 0xFF) / 255.0F;
            GL11.glColor4f(f3 * par3, f7 * par3, f8 * par3, 1.0F);
         }

         tessellator.b();
         tessellator.b(0.0F, 1.0F, 0.0F);
         this.b(par1Block, 0.0, 0.0, 0.0, par1Block.a(1, par2));
         tessellator.a();
         if (flag && this.c) {
            GL11.glColor4f(par3, par3, par3, 1.0F);
         }

         tessellator.b();
         tessellator.b(0.0F, 0.0F, -1.0F);
         this.c(par1Block, 0.0, 0.0, 0.0, par1Block.a(2, par2));
         tessellator.a();
         tessellator.b();
         tessellator.b(0.0F, 0.0F, 1.0F);
         this.d(par1Block, 0.0, 0.0, 0.0, par1Block.a(3, par2));
         tessellator.a();
         tessellator.b();
         tessellator.b(-1.0F, 0.0F, 0.0F);
         this.e(par1Block, 0.0, 0.0, 0.0, par1Block.a(4, par2));
         tessellator.a();
         tessellator.b();
         tessellator.b(1.0F, 0.0F, 0.0F);
         this.f(par1Block, 0.0, 0.0, 0.0, par1Block.a(5, par2));
         tessellator.a();
         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
      }
   }

   public static boolean a(int par0) {
      if (par0 == 0) {
         return true;
      } else if (par0 == 13) {
         return true;
      } else if (par0 == 10) {
         return true;
      } else if (par0 == 11) {
         return true;
      } else if (par0 == 27) {
         return true;
      } else if (par0 == 22) {
         return true;
      } else if (par0 == 21) {
         return true;
      } else {
         return par0 == 26 ? true : par0 == 16;
      }
   }
}
