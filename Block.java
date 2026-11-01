import java.util.ArrayList;
import java.util.Random;

public class Block {
   public static final vj d = new vj("stone", 1.0F, 1.0F);
   public static final vj e = new vj("wood", 1.0F, 1.0F);
   public static final vj f = new vj("gravel", 1.0F, 1.0F);
   public static final vj g = new vj("grass", 1.0F, 1.0F);
   public static final vj h = new vj("stone", 1.0F, 1.0F);
   public static final vj i = new vj("stone", 1.0F, 1.5F);
   public static final vj j = new ak("stone", 1.0F, 1.0F);
   public static final vj k = new vj("cloth", 1.0F, 1.0F);
   public static final vj l = new aj("sand", 1.0F, 1.0F);
   public static final Block[] m = new Block[4096];
   public static final boolean[] n = new boolean[4096];
   public static final int[] o = new int[4096];
   public static final boolean[] p = new boolean[4096];
   public static final int[] q = new int[4096];
   public static final boolean[] r = new boolean[4096];
   public static boolean[] s = new boolean[4096];
   public static final Block t = new do(1, 1).c(1.5F).b(10.0F).a(h).a("stone");
   public static final BlockGrass u = (BlockGrass)new BlockGrass(2).c(0.6F).a(g).a("grass");
   public static final Block v = new aet(3, 2).c(0.5F).a(f).a("dirt");
   public static final Block w = new Block(4, 16, acn.e).c(2.0F).b(10.0F).a(h).a("stonebrick");
   public static final Block x = new nz(5).c(2.0F).b(5.0F).a(e).a("wood").k();
   public static final Block y = new BlockSapling(6, 15).c(0.0F).a(g).a("sapling").k();
   public static final Block z = new Block(7, 17, acn.e).m().b(6000000.0F).a(h).a("bedrock").u();
   public static final Block A = new BlockFlowing(8, acn.g).c(100.0F).f(3).a("water").u().k();
   public static final Block B = new BlockStationary(9, acn.g).c(100.0F).f(3).a("water").u().k();
   public static final Block C = new BlockFlowing(10, acn.h).c(0.0F).a(1.0F).f(255).a("lava").u().k();
   public static final Block D = new BlockStationary(11, acn.h).c(100.0F).a(1.0F).f(255).a("lava").u().k();
   public static final Block E = new BlockSand(12, 18).c(0.5F).a(l).a("sand");
   public static final Block F = new jq(13, 19).c(0.6F).a(f).a("gravel");
   public static final Block G = new jj(14, 32).c(3.0F).b(5.0F).a(h).a("oreGold");
   public static final Block H = new jj(15, 33).c(3.0F).b(5.0F).a(h).a("oreIron");
   public static final Block I = new jj(16, 34).c(3.0F).b(5.0F).a(h).a("oreCoal");
   public static final Block J = new BlockLog(17).c(2.0F).a(e).a("log").k();
   public static final BlockLeaves K = (BlockLeaves)new BlockLeaves(18, 52).c(0.2F).f(1).a(g).a("leaves").k();
   public static final Block L = new BlockSponge(19).c(0.6F).a(g).a("sponge");
   public static final Block M = new xj(20, 49, acn.q, false).c(0.3F).a(j).a("glass");
   public static final Block N = new jj(21, 160).c(3.0F).b(5.0F).a(h).a("oreLapis");
   public static final Block O = new Block(22, 144, acn.e).c(3.0F).b(5.0F).a(h).a("blockLapis");
   public static final Block P = new BlockDispenser(23).c(3.5F).a(h).a("dispenser").k();
   public static final Block Q = new mo(24).a(h).c(0.8F).a("sandStone").k();
   public static final Block R = new BlockNote(25).c(0.8F).a("musicBlock").k();
   public static final Block S = new BlockBed(26).c(0.2F).a("bed").u().k();
   public static final Block T = new BlockRail(27, 179, true).c(0.7F).a(i).a("goldenRail").k();
   public static final Block U = new BlockDetectorRail(28, 195).c(0.7F).a(i).a("detectorRail").k();
   public static final Block V = new BlockPistonBase(29, 106, true).a("pistonStickyBase").k();
   public static final Block W = new BlockWeb(30, 11).f(1).c(4.0F).a("web");
   public static final BlockTallGrass X = (BlockTallGrass)new BlockTallGrass(31, 39).c(0.0F).a(g).a("tallgrass");
   public static final BlockDeadBush Y = (BlockDeadBush)new BlockDeadBush(32, 55).c(0.0F).a(g).a("deadbush");
   public static final Block Z = new BlockPistonBase(33, 107, false).a("pistonBase").k();
   public static final BlockPistonExtension BlockSnowBlock = (BlockPistonExtension)new BlockPistonExtension(34, 107).k();
   public static final Block ab = new BlockCloth().c(0.8F).a(k).a("cloth").k();
   public static final BlockPistonMoving EntityNoteFX = new BlockPistonMoving(36);
   public static final BlockFlower ad = (BlockFlower)new BlockFlower(37, 13).c(0.0F).a(g).a("flower");
   public static final BlockFlower BlockTNT = (BlockFlower)new BlockFlower(38, 12).c(0.0F).a(g).a("rose");
   public static final BlockFlower TileEntityMobSpawnerRenderer = (BlockFlower)new BlockMushroom(39, 29).c(0.0F).a(g).a(0.125F).a("mushroom");
   public static final BlockFlower ag = (BlockFlower)new BlockMushroom(40, 28).c(0.0F).a(g).a("mushroom");
   public static final Block ah = new su(41, 23).c(3.0F).b(10.0F).a(i).a("blockGold");
   public static final Block ai = new su(42, 22).c(5.0F).b(10.0F).a(i).a("blockIron");
   public static final Block aj = new BlockStep(43, true).c(2.0F).b(10.0F).a(h).a("stoneSlab");
   public static final Block ak = new BlockStep(44, false).c(2.0F).b(10.0F).a(h).a("stoneSlab");
   public static final Block BlockPortal = new Block(45, 7, acn.e).c(2.0F).b(10.0F).a(h).a("brick");
   public static final Block NoiseGeneratorPerlin = new BlockTNT(46, 8).c(0.0F).a(g).a("tnt");
   public static final Block MapGenVillage = new fi(47, 35).c(1.5F).a(e).a("bookshelf");
   public static final Block GenLayerHills = new Block(48, 36, acn.e).c(2.0F).b(10.0F).a(h).a("stoneMoss");
   public static final Block ap = new xb(49, 37).c(50.0F).b(2000.0F).a(h).a("obsidian");
   public static final Block aq = new BlockTorch(50, 80).c(0.0F).a(0.9375F).a(e).a("torch").k();
   public static final BlockFire ar = (BlockFire)new BlockFire(51, 31).c(0.0F).a(1.0F).a(e).a("fire").u();
   public static final Block as = new cm(52, 65).c(5.0F).a(i).a("mobSpawner").u();
   public static final Block at = new BlockStairs(53, x).a("stairsWood").k();
   public static final Block au = new BlockChest(54).c(2.5F).a(e).a("chest").k();
   public static final Block EntityThrowable = new BlockRedstoneWire(55, 164).c(0.0F).a(d).a("redstoneDust").u().k();
   public static final Block aw = new jj(56, 50).c(3.0F).b(5.0F).a(h).a("oreDiamond");
   public static final Block EntityAIAttackOnCollide = new su(57, 24).c(5.0F).b(10.0F).a(i).a("blockDiamond");
   public static final Block StructureNetherBridgeStart = new BlockWorkbench(58).c(2.5F).a(e).a("workbench");
   public static final Block TileEntityDispenser = new BlockCrops(59, 88).c(0.0F).a(g).a("crops").u().k();
   public static final Block aA = new BlockFarmland(60).c(0.6F).a(f).a("farmland").k();
   public static final Block aB = new BlockFurnace(61, false).c(3.5F).a(h).a("furnace").k();
   public static final Block aC = new BlockFurnace(62, true).c(3.5F).a(h).a(0.875F).a("furnace").k();
   public static final Block aD = new BlockSign(63, sc.class, true).c(1.0F).a(e).a("sign").u().k();
   public static final Block aE = new BlockDoor(64, acn.d).c(3.0F).a(e).a("doorWood").u().k();
   public static final Block aF = new BlockLadder(65, 83).c(0.4F).a(e).a("ladder").k();
   public static final Block aG = new BlockRail(66, 128, false).c(0.7F).a(i).a("rail").k();
   public static final Block aH = new BlockStairs(67, w).a("stairsStone").k();
   public static final Block aI = new BlockSign(68, sc.class, false).c(1.0F).a(e).a("sign").u().k();
   public static final Block aJ = new BlockLever(69, 96).c(0.5F).a(e).a("lever").k();
   public static final Block aK;
   public static final Block aL = new BlockDoor(71, acn.f).c(5.0F).a(i).a("doorIron").u().k();
   public static final Block aM;
   public static final Block aN = new BlockRedstoneOre(73, 51, false).c(3.0F).b(5.0F).a(h).a("oreRedstone").k();
   public static final Block aO = new BlockRedstoneOre(74, 51, true).a(0.625F).c(3.0F).b(5.0F).a(h).a("oreRedstone").k();
   public static final Block aP = new BlockRedstoneTorch(75, 115, false).c(0.0F).a(e).a("notGate").k();
   public static final Block aQ = new BlockRedstoneTorch(76, 99, true).c(0.0F).a(0.5F).a(e).a("notGate").k();
   public static final Block aR;
   public static final Block aS = new BlockSnow(78, 66).c(0.1F).a(k).a("snow").f(0);
   public static final Block aT = new BlockIce(79, 67).c(0.5F).f(3).a(j).a("ice");
   public static final Block aU = new BlockSnowBlock(80, 66).c(0.2F).a(k).a("snow");
   public static final Block aV = new BlockCactus(81, 70).c(0.4F).a(k).a("cactus");
   public static final Block aW = new agz(82, 72).c(0.6F).a(f).a("clay");
   public static final Block aX = new BlockReed(83, 73).c(0.0F).a(g).a("reeds").u();
   public static final Block aY = new BlockJukeBox(84, 74).c(2.0F).b(10.0F).a(h).a("jukebox").k();
   public static final Block aZ = new BlockFence(85, 4).c(2.0F).b(5.0F).a(e).a("fence");
   public static final Block ba = new BlockPumpkin(86, 102, false).c(1.0F).a(e).a("pumpkin").k();
   public static final Block ItemBucket = new sa(87, 103).c(0.4F).a(h).a("hellrock");
   public static final Block EntityAnimal = new BlockSoulSand(88, 104).c(0.5F).a(l).a("hellsand");
   public static final Block bd = new iq(89, 105, acn.q).c(0.3F).a(j).a(1.0F).a("lightgem");
   public static final BlockPortal be = (BlockPortal)new BlockPortal(90, 14).c(-1.0F).a(j).a(0.75F).a("portal");
   public static final Block WorldGenSwamp = new BlockPumpkin(91, 102, true).c(1.0F).a(e).a(1.0F).a("litpumpkin").k();
   public static final Block bg = new BlockCake(92, 121).c(0.5F).a(k).a("cake").u().k();
   public static final Block ItemShears = new BlockRedstoneRepeater(93, false).c(0.0F).a(e).a("diode").u().k();
   public static final Block bi = new BlockRedstoneRepeater(94, true).c(0.0F).a(0.625F).a(e).a("diode").u().k();
   public static final Block EntityPotion = new BlockLockedChest(95).c(0.0F).a(1.0F).a(e).a("lockedchest").a(true).k();
   public static final Block bk = new BlockTrapDoor(96, acn.d).c(3.0F).a(e).a("trapdoor").u().k();
   public static final Block bl = new BlockSilverfish(97).c(0.75F);
   public static final Block bm = new agi(98).c(1.5F).b(10.0F).a(h).a("stonebricksmooth");
   public static final Block BiomeGenJungle = new pw(99, acn.d, 142, 0).c(0.2F).a(e).a("mushroom").k();
   public static final Block bo = new pw(100, acn.d, 142, 1).c(0.2F).a(e).a("mushroom").k();
   public static final Block EntityAIMoveIndoors = new BlockPane(101, 85, 85, acn.f, true).c(5.0F).b(10.0F).a(i).a("fenceIron");
   public static final Block bq = new BlockPane(102, 49, 148, acn.q, false).c(0.3F).a(j).a("thinGlass");
   public static final Block br = new eb(103).c(1.0F).a(e).a("melon");
   public static final Block bs = new BlockStem(104, ba).c(0.0F).a(e).a("pumpkinStem").k();
   public static final Block EntityFireball = new BlockStem(105, br).c(0.0F).a(e).a("pumpkinStem").k();
   public static final Block bu = new BlockVine(106).c(0.2F).a(g).a("vine").k();
   public static final Block bv = new BlockFenceGate(107, 4).c(2.0F).b(5.0F).a(e).a("fenceGate").k();
   public static final Block bw = new BlockStairs(108, BlockPortal).a("stairsBrick").k();
   public static final Block bx = new BlockStairs(109, bm).a("stairsStoneBrickSmooth").k();
   public static final BlockMycelium by = (BlockMycelium)new BlockMycelium(110).c(0.6F).a(g).a("mycel");
   public static final Block EntityXPOrb = new BlockLilyPad(111, 76).c(0.0F).a(g).a("waterlily");
   public static final Block bA = new Block(112, 224, acn.e).c(2.0F).b(10.0F).a(h).a("netherBrick");
   public static final Block bB = new BlockFence(113, 224, acn.e).c(2.0F).b(10.0F).a(h).a("netherFence");
   public static final Block bC = new BlockStairs(114, bA).a("stairsNetherBrick").k();
   public static final Block bD = new BlockNetherStalk(115).a("netherStalk").k();
   public static final Block bE = new BlockEnchantmentTable(116).c(5.0F).b(2000.0F).a("enchantmentTable");
   public static final Block bF = new BlockBrewingStand(117).c(0.5F).a(0.125F).a("brewingStand").k();
   public static final Block bG = new BlockCauldron(118).c(2.0F).a("cauldron").k();
   public static final Block bH = new BlockEndPortal(119, acn.B).c(-1.0F).b(6000000.0F).a("endPortal");
   public static final Block bI = new BlockEndPortalFrame(120).a(j).a(0.125F).c(-1.0F).a("endPortalFrame").k().b(6000000.0F);
   public static final Block bJ = new Block(121, 175, acn.e).c(3.0F).b(15.0F).a(h).a("whiteStone");
   public static final Block bK = new BlockDragonEgg(122, 167).c(3.0F).b(15.0F).a(h).a(0.125F).a("dragonEgg");
   public static final Block bL = new BlockRedstoneLight(123, false).c(0.3F).a(j).a("redstoneLight");
   public static final Block bM = new BlockRedstoneLight(124, true).c(0.3F).a(j).a("redstoneLight");
   public int bN;
   public final int bO;
   protected float bP;
   protected float bQ;
   protected boolean bR = true;
   protected boolean bS = true;
   protected boolean bT;
   protected boolean bU;
   public double bV;
   public double bW;
   public double bX;
   public double bY;
   public double bZ;
   public double IChunkProvider;
   public vj cb = d;
   public float cc = 1.0F;
   public final acn cd;
   public float ce = 0.6F;
   private String a;

   protected Block(int par1, acn par2Material) {
      if (m[par1] != null) {
         throw new IllegalArgumentException("Slot " + par1 + " EntityAIDoorInteract already occupied by " + m[par1] + " when adding " + this);
      }

      this.cd = par2Material;
      m[par1] = this;
      this.bO = par1;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      n[par1] = this.a();
      o[par1] = this.a() ? 255 : 0;
      p[par1] = !par2Material.b();
   }

   protected Block k() {
      r[this.bO] = true;
      return this;
   }

   protected void l() {
   }

   protected Block(int par1, int par2, acn par3Material) {
      this(par1, par3Material);
      this.bN = par2;
   }

   protected Block a(vj par1StepSound) {
      this.cb = par1StepSound;
      return this;
   }

   protected Block f(int par1) {
      o[this.bO] = par1;
      return this;
   }

   protected Block a(float par1) {
      q[this.bO] = (int)(15.0F * par1);
      return this;
   }

   protected Block b(float par1) {
      this.bQ = par1 * 3.0F;
      return this;
   }

   public static boolean g(int par0) {
      Block block = m[par0];
      return block == null ? false : block.cd.j() && block.b();
   }

   public boolean b() {
      return true;
   }

   public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return !this.cd.c();
   }

   public int d() {
      return 0;
   }

   protected Block c(float par1) {
      this.bP = par1;
      if (this.bQ < par1 * 5.0F) {
         this.bQ = par1 * 5.0F;
      }

      return this;
   }

   protected Block m() {
      this.c(-1.0F);
      return this;
   }

   public float n() {
      return this.bP;
   }

   protected Block a(boolean par1) {
      this.bT = par1;
      return this;
   }

   public boolean o() {
      return this.bT;
   }

   public boolean p() {
      return this.bU;
   }

   public void a(float par1, float par2, float par3, float par4, float par5, float par6) {
      this.bV = par1;
      this.bW = par2;
      this.bX = par3;
      this.bY = par4;
      this.bZ = par5;
      this.IChunkProvider = par6;
   }

   public float getBlockBrightness(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return par1IBlockAccess.getBrightness(par2, par3, par4, q[this.bO]);
   }

   public int getMixedBrightnessForBlock(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return par1IBlockAccess.getLightBrightnessForSkyBlocks(par2, par3, par4, q[this.bO]);
   }

   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      if (par5 == 0 && this.bW > 0.0) {
         return true;
      } else if (par5 == 1 && this.bZ < 1.0) {
         return true;
      } else if (par5 == 2 && this.bX > 0.0) {
         return true;
      } else if (par5 == 3 && this.IChunkProvider < 1.0) {
         return true;
      } else if (par5 == 4 && this.bV > 0.0) {
         return true;
      } else {
         return par5 == 5 && this.bY < 1.0 ? true : !par1IBlockAccess.isBlockOpaqueCube(par2, par3, par4);
      }
   }

   public boolean isBlockSolid(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      return par1IBlockAccess.getBlockMaterial(par2, par3, par4).a();
   }

   public int getBlockTexture(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      return this.a(par5, par1IBlockAccess.getBlockMetadata(par2, par3, par4));
   }

   public int a(int par1, int par2) {
      return this.a_(par1);
   }

   public int a_(int par1) {
      return this.bN;
   }

   public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      return AxisAlignedBB.b(par2 + this.bV, par3 + this.bW, par4 + this.bX, par2 + this.bY, par3 + this.bZ, par4 + this.IChunkProvider);
   }

   public void getCollidingBoundingBoxes(World par1World, long par2, int par3, long par4, AxisAlignedBB par5AxisAlignedBB, ArrayList par6ArrayList) {
      AxisAlignedBB axisalignedbb = this.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
      if (axisalignedbb != null && par5AxisAlignedBB.a(axisalignedbb)) {
         par6ArrayList.add(axisalignedbb);
      }
   }

   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      return AxisAlignedBB.b(par2 + this.bV, par3 + this.bW, par4 + this.bX, par2 + this.bY, par3 + this.bZ, par4 + this.IChunkProvider);
   }

   public boolean a() {
      return true;
   }

   public boolean a(int par1, boolean par2) {
      return this.j();
   }

   public boolean j() {
      return true;
   }

   public void updateTick(World world, long i, int j, long k, Random random) {
   }

   public void randomDisplayTick(World world, long i, int j, long k, Random random) {
   }

   public void onBlockDestroyedByPlayer(World world, long i, int j, long k, int l) {
   }

   public void onNeighborBlockChange(World world, long i, int j, long k, int l) {
   }

   public int e() {
      return 10;
   }

   public void onBlockAdded(World world, long i, int j, long k) {
   }

   public void onBlockRemoval(World world, long i, int j, long k) {
   }

   public int a(Random par1Random) {
      return 1;
   }

   public int a(int par1, Random par2Random, int par3) {
      return this.bO;
   }

   public float a(EntityPlayer par1EntityPlayer) {
      if (this.bP < 0.0F) {
         return 0.0F;
      } else {
         return !par1EntityPlayer.b(this) ? 1.0F / this.bP / 100.0F : par1EntityPlayer.a(this) / this.bP / 30.0F;
      }
   }

   public final void dropBlockAsItem(World par1World, long par2, int par3, long par4, int par5, int par6) {
      this.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, 1.0F, par6);
   }

   public void dropBlockAsItemWithChance(World par1World, long par2, int par3, long par4, int par5, float par6, int par7) {
      if (!par1World.F) {
         int i = this.a(par7, par1World.r);

         for (int j = 0; j < i; j++) {
            if (!(par1World.r.nextFloat() > par6)) {
               int k = this.a(par5, par1World.r, par7);
               if (k > 0) {
                  this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(k, 1, this.c(par5)));
               }
            }
         }
      }
   }

   protected void dropBlockAsItem_do(World par1World, long par2, int par3, long par4, ItemStack par5ItemStack) {
      if (!par1World.F) {
         float f = 0.7F;
         double d = par1World.r.nextFloat() * f + (1.0F - f) * 0.5;
         double d1 = par1World.r.nextFloat() * f + (1.0F - f) * 0.5;
         double d2 = par1World.r.nextFloat() * f + (1.0F - f) * 0.5;
         EntityItem entityitem = new EntityItem(par1World, par2 + d, par3 + d1, par4 + d2, par5ItemStack);
         entityitem.c = 10;
         par1World.a(entityitem);
      }
   }

   protected int c(int par1) {
      return 0;
   }

   public float a(Entity par1Entity) {
      return this.bQ / 5.0F;
   }

   public MovingObjectPosition collisionRayTrace(World par1World, long par2, int par3, long par4, bo par5Vec3D, bo par6Vec3D) {
      this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
      par5Vec3D = par5Vec3D.c(-par2, -par3, -par4);
      par6Vec3D = par6Vec3D.c(-par2, -par3, -par4);
      bo vec3d = par5Vec3D.a(par6Vec3D, this.bV);
      bo vec3d1 = par5Vec3D.a(par6Vec3D, this.bY);
      bo vec3d2 = par5Vec3D.b(par6Vec3D, this.bW);
      bo vec3d3 = par5Vec3D.b(par6Vec3D, this.bZ);
      bo vec3d4 = par5Vec3D.c(par6Vec3D, this.bX);
      bo vec3d5 = par5Vec3D.c(par6Vec3D, this.IChunkProvider);
      if (!this.a(vec3d)) {
         vec3d = null;
      }

      if (!this.a(vec3d1)) {
         vec3d1 = null;
      }

      if (!this.b(vec3d2)) {
         vec3d2 = null;
      }

      if (!this.b(vec3d3)) {
         vec3d3 = null;
      }

      if (!this.c(vec3d4)) {
         vec3d4 = null;
      }

      if (!this.c(vec3d5)) {
         vec3d5 = null;
      }

      bo vec3d6 = null;
      if (vec3d != null && (vec3d6 == null || par5Vec3D.d(vec3d) < par5Vec3D.d(vec3d6))) {
         vec3d6 = vec3d;
      }

      if (vec3d1 != null && (vec3d6 == null || par5Vec3D.d(vec3d1) < par5Vec3D.d(vec3d6))) {
         vec3d6 = vec3d1;
      }

      if (vec3d2 != null && (vec3d6 == null || par5Vec3D.d(vec3d2) < par5Vec3D.d(vec3d6))) {
         vec3d6 = vec3d2;
      }

      if (vec3d3 != null && (vec3d6 == null || par5Vec3D.d(vec3d3) < par5Vec3D.d(vec3d6))) {
         vec3d6 = vec3d3;
      }

      if (vec3d4 != null && (vec3d6 == null || par5Vec3D.d(vec3d4) < par5Vec3D.d(vec3d6))) {
         vec3d6 = vec3d4;
      }

      if (vec3d5 != null && (vec3d6 == null || par5Vec3D.d(vec3d5) < par5Vec3D.d(vec3d6))) {
         vec3d6 = vec3d5;
      }

      if (vec3d6 == null) {
         return null;
      }

      byte byte0 = -1;
      if (vec3d6 == vec3d) {
         byte0 = 4;
      }

      if (vec3d6 == vec3d1) {
         byte0 = 5;
      }

      if (vec3d6 == vec3d2) {
         byte0 = 0;
      }

      if (vec3d6 == vec3d3) {
         byte0 = 1;
      }

      if (vec3d6 == vec3d4) {
         byte0 = 2;
      }

      if (vec3d6 == vec3d5) {
         byte0 = 3;
      }

      return new MovingObjectPosition(par2, par3, par4, byte0, vec3d6.c(par2, par3, par4));
   }

   private boolean a(bo par1Vec3D) {
      return par1Vec3D == null ? false : par1Vec3D.b >= this.bW && par1Vec3D.b <= this.bZ && par1Vec3D.c >= this.bX && par1Vec3D.c <= this.IChunkProvider;
   }

   private boolean b(bo par1Vec3D) {
      return par1Vec3D == null ? false : par1Vec3D.a >= this.bV && par1Vec3D.a <= this.bY && par1Vec3D.c >= this.bX && par1Vec3D.c <= this.IChunkProvider;
   }

   private boolean c(bo par1Vec3D) {
      return par1Vec3D == null ? false : par1Vec3D.a >= this.bV && par1Vec3D.a <= this.bY && par1Vec3D.b >= this.bW && par1Vec3D.b <= this.bZ;
   }

   public void onBlockDestroyedByExplosion(World world, long i, int j, long k) {
   }

   public int c() {
      return 0;
   }

   public boolean canPlaceBlockOnSide(World par1World, long par2, int par3, long par4, int par5) {
      return this.canPlaceBlockAt(par1World, par2, par3, par4);
   }

   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockId(par2, par3, par4);
      return i == 0 || m[i].cd.i();
   }

   public boolean blockActivated(World par1World, long par2, int par3, long i, EntityPlayer entityplayer) {
      return false;
   }

   public void onEntityWalking(World world, long i, int j, long k, Entity entity) {
   }

   public void onBlockPlaced(World world, long i, int j, long k, int l) {
   }

   public void onBlockClicked(World world, long i, int j, long k, EntityPlayer entityplayer) {
   }

   public void velocityToAddToEntity(World world, long i, int j, long k, Entity entity, bo vec3d) {
   }

   public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, long i, int j, long k) {
   }

   public int i() {
      return 16777215;
   }

   public int d(int par1) {
      return 16777215;
   }

   public int colorMultiplier(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return 16777215;
   }

   public boolean isPoweringTo(IBlockAccess par1IBlockAccess, long par2, int par3, long i, int j) {
      return false;
   }

   public boolean g() {
      return false;
   }

   public void onEntityCollidedWithBlock(World world, long i, int j, long k, Entity entity) {
   }

   public boolean isIndirectlyPoweringTo(World par1World, long par2, int par3, long i, int j) {
      return false;
   }

   public void h() {
   }

   public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, long par3, int par4, long par5, int par6) {
      par2EntityPlayer.a(gv.C[this.bO], 1);
      par2EntityPlayer.c(0.025F);
      if (this.q() && ais.d(par2EntityPlayer.ap)) {
         ItemStack itemstack = this.b(par6);
         if (itemstack != null) {
            this.dropBlockAsItem_do(par1World, par3, par4, par5, itemstack);
         }
      } else {
         int i = ais.e(par2EntityPlayer.ap);
         this.dropBlockAsItem(par1World, par3, par4, par5, par6, i);
      }
   }

   protected boolean q() {
      return this.b() && !this.bU;
   }

   protected ItemStack b(int par1) {
      int i = 0;
      if (this.bO >= 0 && this.bO < Item.e.length && Item.e[this.bO].g()) {
         i = par1;
      }

      return new ItemStack(this.bO, 1, i);
   }

   public int a(int par1, Random par2Random) {
      return this.a(par2Random);
   }

   public boolean canBlockStay(World par1World, long par2, int par3, long i) {
      return true;
   }

   public void onBlockPlacedBy(World world, long i, int j, long k, EntityLiving entityliving) {
   }

   public Block a(String par1Str) {
      this.a = "tile." + par1Str;
      return this;
   }

   public String r() {
      return cy.a(this.s() + ".name");
   }

   public String s() {
      return this.a;
   }

   public void powerBlock(World world, long i, int j, long k, int l, int i1) {
   }

   public boolean t() {
      return this.bS;
   }

   protected Block u() {
      this.bS = false;
      return this;
   }

   public int f() {
      return this.cd.l();
   }

   public float getAmbientOcclusionLightValue(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return par1IBlockAccess.isBlockNormalCube(par2, par3, par4) ? 0.2F : 1.0F;
   }

   public void onFallenUpon(World world, long i, int j, long k, Entity entity, float f) {
   }

   static {
      aK = new BlockPressurePlate(70, t.bN, agw.b, acn.e).c(0.5F).a(h).a("pressurePlate").k();
      aM = new BlockPressurePlate(72, x.bN, agw.a, acn.d).c(0.5F).a(e).a("pressurePlate").k();
      aR = new BlockButton(77, t.bN).c(0.5F).a(h).a("button").k();
      Item.e[ab.bO] = new uc(ab.bO - 256).a("cloth");
      Item.e[J.bO] = new aba(J.bO - 256, J).a("log");
      Item.e[x.bO] = new aba(x.bO - 256, x).a("wood");
      Item.e[bm.bO] = new aba(bm.bO - 256, bm).a("stonebricksmooth");
      Item.e[Q.bO] = new aba(Q.bO - 256, Q).a("sandStone");
      Item.e[ak.bO] = new ItemSlab(ak.bO - 256).a("stoneSlab");
      Item.e[y.bO] = new jh(y.bO - 256).a("sapling");
      Item.e[K.bO] = new ph(K.bO - 256).a("leaves");
      Item.e[bu.bO] = new aky(bu.bO - 256, false);
      Item.e[X.bO] = new aky(X.bO - 256, true).a(new String[]{"shrub", "grass", "fern"});
      Item.e[EntityXPOrb.bO] = new ItemLilyPad(EntityXPOrb.bO - 256);
      Item.e[Z.bO] = new agc(Z.bO - 256);
      Item.e[V.bO] = new agc(V.bO - 256);

      for (int i = 0; i < 256; i++) {
         if (m[i] != null) {
            if (Item.e[i] == null) {
               Item.e[i] = new ItemBlock(i - 256);
               m[i].l();
            }

            boolean flag = false;
            if (i > 0 && m[i].d() == 10) {
               flag = true;
            }

            if (i > 0 && m[i] instanceof BlockStep) {
               flag = true;
            }

            if (i == aA.bO) {
               flag = true;
            }

            if (p[i]) {
               flag = true;
            }

            s[i] = flag;
         }
      }

      p[0] = true;
      gv.b();
   }
}
