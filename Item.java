import java.util.List;
import java.util.Random;

public class Item {
   protected static Random d = new Random();
   public static Item[] e = new Item[32000];
   public static Item f = new akd(0, uk.c).c(2, 5).a("shovelIron");
   public static Item g = new au(1, uk.c).c(2, 6).a("pickaxeIron");
   public static Item h = new nx(2, uk.c).c(2, 7).a("hatchetIron");
   public static Item i = new ItemFlintAndSteel(3).c(5, 0).a("flintAndSteel");
   public static Item j = new amm(4, 4, 0.3F, false).c(10, 0).a("apple");
   public static Item k = new mm(5).c(5, 1).a("bow");
   public static Item l = new Item(6).c(5, 2).a("arrow");
   public static Item m = new mz(7).c(7, 0).a("coal");
   public static Item n = new Item(8).c(7, 3).a("emerald");
   public static Item o = new Item(9).c(7, 1).a("ingotIron");
   public static Item p = new Item(10).c(7, 2).a("ingotGold");
   public static Item q = new ItemSword(11, uk.c).c(2, 4).a("swordIron");
   public static Item r = new ItemSword(12, uk.a).c(0, 4).a("swordWood");
   public static Item s = new akd(13, uk.a).c(0, 5).a("shovelWood");
   public static Item t = new au(14, uk.a).c(0, 6).a("pickaxeWood");
   public static Item u = new nx(15, uk.a).c(0, 7).a("hatchetWood");
   public static Item v = new ItemSword(16, uk.b).c(1, 4).a("swordStone");
   public static Item w = new akd(17, uk.b).c(1, 5).a("shovelStone");
   public static Item x = new au(18, uk.b).c(1, 6).a("pickaxeStone");
   public static Item y = new nx(19, uk.b).c(1, 7).a("hatchetStone");
   public static Item z = new ItemSword(20, uk.d).c(3, 4).a("swordDiamond");
   public static Item A = new akd(21, uk.d).c(3, 5).a("shovelDiamond");
   public static Item B = new au(22, uk.d).c(3, 6).a("pickaxeDiamond");
   public static Item C = new nx(23, uk.d).c(3, 7).a("hatchetDiamond");
   public static Item D = new Item(24).c(5, 3).j().a("stick");
   public static Item E = new Item(25).c(7, 4).a("bowl");
   public static Item F = new br(26, 8).c(8, 4).a("mushroomStew");
   public static Item G = new ItemSword(27, uk.e).c(4, 4).a("swordGold");
   public static Item H = new akd(28, uk.e).c(4, 5).a("shovelGold");
   public static Item I = new au(29, uk.e).c(4, 6).a("pickaxeGold");
   public static Item J = new nx(30, uk.e).c(4, 7).a("hatchetGold");
   public static Item K = new Item(31).c(8, 0).a("string");
   public static Item L = new Item(32).c(8, 1).a("feather");
   public static Item M = new Item(33).c(8, 2).a("sulphur").b("+14&13-13");
   public static Item N = new ItemHoe(34, uk.a).c(0, 8).a("hoeWood");
   public static Item O = new ItemHoe(35, uk.b).c(1, 8).a("hoeStone");
   public static Item P = new ItemHoe(36, uk.c).c(2, 8).a("hoeIron");
   public static Item Q = new ItemHoe(37, uk.d).c(3, 8).a("hoeDiamond");
   public static Item R = new ItemHoe(38, uk.e).c(4, 8).a("hoeGold");
   public static Item S = new ItemSeeds(39, Block.TileEntityDispenser.bO, Block.aA.bO).c(9, 0).a("seeds");
   public static Item T = new Item(40).c(9, 1).a("wheat");
   public static Item U = new amm(41, 5, 0.6F, false).c(9, 2).a("bread");
   public static Item V = new ql(42, cg.a, 0, 0).c(0, 0).a("helmetCloth");
   public static Item W = new ql(43, cg.a, 0, 1).c(0, 1).a("chestplateCloth");
   public static Item X = new ql(44, cg.a, 0, 2).c(0, 2).a("leggingsCloth");
   public static Item Y = new ql(45, cg.a, 0, 3).c(0, 3).a("bootsCloth");
   public static Item Z = new ql(46, cg.b, 1, 0).c(1, 0).a("helmetChain");
   public static Item BlockSnowBlock = new ql(47, cg.b, 1, 1).c(1, 1).a("chestplateChain");
   public static Item ab = new ql(48, cg.b, 1, 2).c(1, 2).a("leggingsChain");
   public static Item EntityNoteFX = new ql(49, cg.b, 1, 3).c(1, 3).a("bootsChain");
   public static Item ad = new ql(50, cg.c, 2, 0).c(2, 0).a("helmetIron");
   public static Item BlockTNT = new ql(51, cg.c, 2, 1).c(2, 1).a("chestplateIron");
   public static Item TileEntityMobSpawnerRenderer = new ql(52, cg.c, 2, 2).c(2, 2).a("leggingsIron");
   public static Item ag = new ql(53, cg.c, 2, 3).c(2, 3).a("bootsIron");
   public static Item ah = new ql(54, cg.e, 3, 0).c(3, 0).a("helmetDiamond");
   public static Item ai = new ql(55, cg.e, 3, 1).c(3, 1).a("chestplateDiamond");
   public static Item aj = new ql(56, cg.e, 3, 2).c(3, 2).a("leggingsDiamond");
   public static Item ak = new ql(57, cg.e, 3, 3).c(3, 3).a("bootsDiamond");
   public static Item BlockPortal = new ql(58, cg.d, 4, 0).c(4, 0).a("helmetGold");
   public static Item NoiseGeneratorPerlin = new ql(59, cg.d, 4, 1).c(4, 1).a("chestplateGold");
   public static Item MapGenVillage = new ql(60, cg.d, 4, 2).c(4, 2).a("leggingsGold");
   public static Item GenLayerHills = new ql(61, cg.d, 4, 3).c(4, 3).a("bootsGold");
   public static Item ap = new Item(62).c(6, 0).a("flint");
   public static Item aq = new amm(63, 3, 0.3F, true).c(7, 5).a("porkchopRaw");
   public static Item ar = new amm(64, 8, 0.8F, true).c(8, 5).a("porkchopCooked");
   public static Item as = new ItemPainting(65).c(10, 1).a("painting");
   public static Item at = new sg(66, 4, 1.2F, false).t().a(aad.l.H, 5, 0, 1.0F).c(11, 0).a("appleGold");
   public static Item au = new ItemSign(67).c(10, 2).a("sign");
   public static Item EntityThrowable = new ItemDoor(68, acn.d).c(11, 2).a("doorWood");
   public static Item aw = new ItemBucket(69, 0).c(10, 4).a("bucket");
   public static Item EntityAIAttackOnCollide = new ItemBucket(70, Block.A.bO).c(11, 4).a("bucketWater").a(aw);
   public static Item StructureNetherBridgeStart = new ItemBucket(71, Block.C.bO).c(12, 4).a("bucketLava").a(aw);
   public static Item TileEntityDispenser = new ItemMinecart(72, 0).c(7, 8).a("minecart");
   public static Item aA = new nc(73).c(8, 6).a("saddle");
   public static Item aB = new ItemDoor(74, acn.f).c(12, 2).a("doorIron");
   public static Item aC = new ItemRedstone(75).c(8, 3).a("redstone").b("-5+6-7");
   public static Item aD = new cv(76).c(14, 0).a("snowball");
   public static Item aE = new ItemBoat(77).c(8, 8).a("boat");
   public static Item aF = new Item(78).c(7, 6).a("leather");
   public static Item aG = new pe(79).c(13, 4).a("milk").a(aw);
   public static Item aH = new Item(80).c(6, 1).a("brick");
   public static Item aI = new Item(81).c(9, 3).a("clay");
   public static Item aJ = new ItemReed(82, Block.aX).c(11, 1).a("reeds");
   public static Item aK = new Item(83).c(10, 3).a("paper");
   public static Item aL = new Item(84).c(11, 3).a("book");
   public static Item aM = new Item(85).c(14, 1).a("slimeball");
   public static Item aN = new ItemMinecart(86, 1).c(7, 9).a("minecartChest");
   public static Item aO = new ItemMinecart(87, 2).c(7, 10).a("minecartFurnace");
   public static Item aP = new adc(88).c(12, 0).a("egg");
   public static Item aQ = new Item(89).c(6, 3).a("compass");
   public static Item aR = new vk(90).c(5, 4).a("fishingRod");
   public static Item aS = new Item(91).c(6, 4).a("clock");
   public static Item aT = new Item(92).c(9, 4).a("yellowDust").b("+5-6-7");
   public static Item aU = new amm(93, 2, 0.3F, false).c(9, 5).a("fishRaw");
   public static Item aV = new amm(94, 5, 0.6F, false).c(10, 5).a("fishCooked");
   public static Item aW = new ItemDye(95).c(14, 4).a("dyePowder");
   public static Item aX = new Item(96).c(12, 1).a("bone").j();
   public static Item aY = new Item(97).c(13, 0).a("sugar").b("-0+1-2-3&4-4+13");
   public static Item aZ = new ItemReed(98, Block.bg).f(1).c(13, 1).a("cake");
   public static Item ba = new ItemBed(99).f(1).c(13, 2).a("bed");
   public static Item ItemBucket = new ItemReed(100, Block.ItemShears).c(6, 5).a("diode");
   public static Item EntityAnimal = new amm(101, 1, 0.1F, false).c(12, 5).a("cookie");
   public static ItemMap bd = (ItemMap)new ItemMap(102).c(12, 3).a("map");
   public static ItemShears be = (ItemShears)new ItemShears(103).c(13, 5).a("shears");
   public static Item WorldGenSwamp = new amm(104, 2, 0.3F, false).c(13, 6).a("melon");
   public static Item bg = new ItemSeeds(105, Block.bs.bO, Block.aA.bO).c(13, 3).a("seeds_pumpkin");
   public static Item ItemShears = new ItemSeeds(106, Block.EntityFireball.bO, Block.aA.bO).c(14, 3).a("seeds_melon");
   public static Item bi = new amm(107, 3, 0.3F, true).c(9, 6).a("beefRaw");
   public static Item EntityPotion = new amm(108, 8, 0.8F, true).c(10, 6).a("beefCooked");
   public static Item bk = new amm(109, 2, 0.3F, true).a(aad.s.H, 30, 0, 0.3F).c(9, 7).a("chickenRaw");
   public static Item bl = new amm(110, 6, 0.6F, true).c(10, 7).a("chickenCooked");
   public static Item bm = new amm(111, 4, 0.1F, true).a(aad.s.H, 30, 0, 0.8F).c(11, 5).a("rottenFlesh");
   public static Item BiomeGenJungle = new ItemEnderPearl(112).c(11, 6).a("enderPearl");
   public static Item bo = new Item(113).c(12, 6).a("blazeRod");
   public static Item EntityAIMoveIndoors = new Item(114).c(11, 7).a("ghastTear").b("+0-1-2-3&4-4+13");
   public static Item bq = new Item(115).c(12, 7).a("goldNugget");
   public static Item br = new ItemSeeds(116, Block.bD.bO, Block.EntityAnimal.bO).c(13, 7).a("netherStalkSeeds").b("+4");
   public static ei bs = (ei)new ei(117).c(13, 8).a("potion");
   public static Item EntityFireball = new ItemGlassBottle(118).c(12, 8).a("glassBottle");
   public static Item bu = new amm(119, 2, 0.8F, false).a(aad.u.H, 5, 0, 1.0F).c(11, 8).a("spiderEye").b("-0-1+2-3&4-4+13");
   public static Item bv = new Item(120).c(10, 8).a("fermentedSpiderEye").b("-0+3-4+13");
   public static Item bw = new Item(121).c(13, 9).a("blazePowder").b("+0-1-2+3&4-4+13");
   public static Item bx = new Item(122).c(13, 10).a("magmaCream").b("+0+1-2-3&4-4+13");
   public static Item by = new ItemReed(123, Block.bF).c(12, 10).a("brewingStand");
   public static Item EntityXPOrb = new ItemReed(124, Block.bG).c(12, 9).a("cauldron");
   public static Item bA = new ItemEnderEye(125).c(11, 9).a("eyeOfEnder");
   public static Item bB = new Item(126).c(9, 8).a("speckledMelon").b("+0-1+2-3&4-4+13");
   public static Item bC = new ItemMonsterPlacer(127).c(9, 9).a("monsterPlacer");
   public static Item bD = new xi(128).c(11, 10).a("expBottle");
   public static Item bE = new ItemFireball(129).c(14, 2).a("fireball");
   public static Item bF = new ItemRecord(2000, "13").c(0, 15).a("record");
   public static Item bG = new ItemRecord(2001, "cat").c(1, 15).a("record");
   public static Item bH = new ItemRecord(2002, "blocks").c(2, 15).a("record");
   public static Item bI = new ItemRecord(2003, "chirp").c(3, 15).a("record");
   public static Item bJ = new ItemRecord(2004, "far").c(4, 15).a("record");
   public static Item bK = new ItemRecord(2005, "mall").c(5, 15).a("record");
   public static Item bL = new ItemRecord(2006, "mellohi").c(6, 15).a("record");
   public static Item bM = new ItemRecord(2007, "stal").c(7, 15).a("record");
   public static Item bN = new ItemRecord(2008, "strad").c(8, 15).a("record");
   public static Item bO = new ItemRecord(2009, "ward").c(9, 15).a("record");
   public static Item bP = new ItemRecord(2010, "11").c(10, 15).a("record");
   public final int bQ;
   protected int bR = 64;
   private int a = 0;
   protected int bS;
   protected boolean bT = false;
   protected boolean bU = false;
   private Item b = null;
   private String c = null;
   private String bV;

   protected Item(int par1) {
      this.bQ = 256 + par1;
      if (e[256 + par1] != null) {
         System.out.println("CONFLICT @ " + par1);
      }

      e[256 + par1] = this;
   }

   public Item e(int par1) {
      this.bS = par1;
      return this;
   }

   public Item f(int par1) {
      this.bR = par1;
      return this;
   }

   public Item c(int par1, int par2) {
      this.bS = par1 + par2 * 16;
      return this;
   }

   public int b(int par1) {
      return this.bS;
   }

   public final int g(ItemStack par1ItemStack) {
      return this.b(par1ItemStack.i());
   }

   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long i, int j, long k, int l) {
      return false;
   }

   public float a(ItemStack par1ItemStack, Block par2Block) {
      return 1.0F;
   }

   public ItemStack a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      return par1ItemStack;
   }

   public ItemStack b(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      return par1ItemStack;
   }

   public int f() {
      return this.bR;
   }

   public int a(int par1) {
      return 0;
   }

   public boolean g() {
      return this.bU;
   }

   protected Item a(boolean par1) {
      this.bU = par1;
      return this;
   }

   public int h() {
      return this.a;
   }

   protected Item g(int par1) {
      this.a = par1;
      return this;
   }

   public boolean i() {
      return this.a > 0 && !this.bU;
   }

   public boolean a(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {
      return false;
   }

   public boolean onBlockDestroyed(ItemStack par1ItemStack, int par2, long par3, int i, long j, EntityLiving entityliving) {
      return false;
   }

   public int a(Entity par1Entity) {
      return 1;
   }

   public boolean a(Block par1Block) {
      return false;
   }

   public void a(ItemStack itemstack, EntityLiving entityliving) {
   }

   public Item j() {
      this.bT = true;
      return this;
   }

   public boolean a() {
      return this.bT;
   }

   public boolean A_() {
      return false;
   }

   public Item a(String par1Str) {
      this.bV = "item." + par1Str;
      return this;
   }

   public String h(ItemStack par1ItemStack) {
      String s = this.a(par1ItemStack);
      return s == null ? "" : cy.a(s);
   }

   public String e() {
      return this.bV;
   }

   public String a(ItemStack par1ItemStack) {
      return this.bV;
   }

   public Item a(Item par1Item) {
      this.b = par1Item;
      return this;
   }

   public boolean i(ItemStack par1ItemStack) {
      return true;
   }

   public boolean k() {
      return false;
   }

   public Item l() {
      return this.b;
   }

   public boolean m() {
      return this.b != null;
   }

   public String n() {
      return cy.a(this.e() + ".name");
   }

   public int b(int par1, int par2) {
      return 16777215;
   }

   public void a(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
   }

   public void c(ItemStack itemstack, World world, EntityPlayer entityplayer) {
   }

   public aaq c(ItemStack par1ItemStack) {
      return aaq.a;
   }

   public int b(ItemStack par1ItemStack) {
      return 0;
   }

   public void a(ItemStack itemstack, World world, EntityPlayer entityplayer, int i) {
   }

   protected Item b(String par1Str) {
      this.c = par1Str;
      return this;
   }

   public String o() {
      return this.c;
   }

   public boolean p() {
      return this.c != null;
   }

   public void a(ItemStack itemstack, List list) {
   }

   public String d(ItemStack par1ItemStack) {
      return ("" + adn.a().c(this.h(par1ItemStack))).trim();
   }

   public boolean e(ItemStack par1ItemStack) {
      return par1ItemStack.u();
   }

   public fo f(ItemStack par1ItemStack) {
      return par1ItemStack.u() ? fo.c : fo.a;
   }

   public boolean j(ItemStack par1ItemStack) {
      return this.f() == 1 && this.i();
   }

   protected MovingObjectPosition a(World par1World, EntityPlayer par2EntityPlayer, boolean par3) {
      float f = 1.0F;
      float f1 = par2EntityPlayer.x + (par2EntityPlayer.v - par2EntityPlayer.x) * f;
      float f2 = par2EntityPlayer.w + (par2EntityPlayer.u - par2EntityPlayer.w) * f;
      double d = par2EntityPlayer.l + (par2EntityPlayer.o - par2EntityPlayer.l) * f;
      double d1 = par2EntityPlayer.m + (par2EntityPlayer.p - par2EntityPlayer.m) * f + 1.62 - par2EntityPlayer.H;
      double d2 = par2EntityPlayer.n + (par2EntityPlayer.q - par2EntityPlayer.n) * f;
      bo vec3d = bo.b(d, d1, d2);
      float f3 = MathHelper.b(-f2 * 0.01745329F - (float) Math.PI);
      float f4 = MathHelper.a(-f2 * 0.01745329F - (float) Math.PI);
      float f5 = -MathHelper.b(-f1 * 0.01745329F);
      float f6 = MathHelper.a(-f1 * 0.01745329F);
      float f7 = f4 * f5;
      float f8 = f6;
      float f9 = f3 * f5;
      double d3 = 5.0;
      bo vec3d1 = vec3d.c(f7 * d3, f8 * d3, f9 * d3);
      return par1World.a(vec3d, vec3d1, par3, !par3);
   }

   public int b() {
      return 0;
   }

   public boolean c() {
      return false;
   }

   public int a(int par1, int par2) {
      return this.b(par1);
   }

   static {
      gv.c();
   }
}
