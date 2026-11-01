import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BiomeGenBase {
   public static final BiomeGenBase[] a = new BiomeGenBase[256];
   public static final BiomeGenBase b = new tm(0).b(112).a("Ocean").b(-1.0F, 0.4F);
   public static final BiomeGenBase c = new jw(1).b(9286496).a("Plains").a(0.8F, 0.4F);
   public static final BiomeGenBase d = new BiomeGenDesert(2).b(16421912).a("Desert").m().a(2.0F, 0.0F).b(0.1F, 0.2F);
   public static final BiomeGenBase e = new ahq(3).b(6316128).a("Extreme Hills").b(0.2F, 1.3F).a(0.3F, 0.5F);
   public static final BiomeGenBase f = new agj(4).b(353825).a("Forest").a(5159473).a(0.9F, 0.8F);
   public static final BiomeGenBase g = new sp(5).b(747097).a("Taiga").a(5159473).b().a(0.05F, 0.8F).b(0.1F, 0.4F);
   public static final BiomeGenBase h = new BiomeGenSwamp(6).b(522674).a("Swampland").a(9154376).b(-0.2F, 0.1F).a(0.8F, 0.9F);
   public static final BiomeGenBase i = new jo(7).b(255).a("River").b(-0.5F, 0.0F);
   public static final BiomeGenBase j = new BiomeGenHell(8).b(16711680).a("Hell").m().a(2.0F, 0.0F);
   public static final BiomeGenBase k = new BiomeGenEnd(9).b(8421631).a("Sky").m();
   public static final BiomeGenBase l = new tm(10).b(9474208).a("FrozenOcean").b().b(-1.0F, 0.5F).a(0.0F, 0.5F);
   public static final BiomeGenBase m = new jo(11).b(10526975).a("FrozenRiver").b().b(-0.5F, 0.0F).a(0.0F, 0.5F);
   public static final BiomeGenBase n = new lp(12).b(16777215).a("Ice Plains").b().a(0.0F, 0.5F);
   public static final BiomeGenBase o = new lp(13).b(10526880).a("Ice Mountains").b().b(0.2F, 1.2F).a(0.0F, 0.5F);
   public static final BiomeGenBase p = new BiomeGenMushroomIsland(14).b(16711935).a("MushroomIsland").a(0.9F, 1.0F).b(0.2F, 1.0F);
   public static final BiomeGenBase q = new BiomeGenMushroomIsland(15).b(10486015).a("MushroomIslandShore").a(0.9F, 1.0F).b(-1.0F, 0.1F);
   public static final BiomeGenBase r = new ng(16).b(16440917).a("Beach").a(0.8F, 0.4F).b(0.0F, 0.1F);
   public static final BiomeGenBase s = new BiomeGenDesert(17).b(13786898).a("DesertHills").m().a(2.0F, 0.0F).b(0.2F, 0.7F);
   public static final BiomeGenBase t = new agj(18).b(2250012).a("ForestHills").a(5159473).a(0.9F, 0.8F).b(0.2F, 0.6F);
   public static final BiomeGenBase u = new sp(19).b(1456435).a("TaigaHills").b().a(5159473).a(0.05F, 0.8F).b(0.2F, 0.7F);
   public static final BiomeGenBase v = new ahq(20).b(7501978).a("Extreme Hills Edge").b(0.2F, 0.8F).a(0.3F, 0.5F);
   public static final BiomeGenBase w = new BiomeGenJungle(21).b(5470985).a("Jungle").a(5470985).a(1.2F, 1.2F).b(0.2F, 0.4F);
   public static final BiomeGenBase x = new BiomeGenJungle(22).b(2900485).a("JungleHills").a(5470985).a(1.2F, 1.2F).b(1.8F, 0.2F);
   public String y;
   public int z;
   public byte A = (byte)Block.u.bO;
   public byte B = (byte)Block.v.bO;
   public int C = 5169201;
   public float D = 0.1F;
   public float E = 0.3F;
   public float F = 0.75F;
   public float G = 0.75F;
   public int H = 16777215;
   public BiomeDecorator I;
   protected List J = new ArrayList();
   protected List K = new ArrayList();
   private boolean R;
   private boolean S = true;
   public final int M;
   protected WorldGenTrees N = new WorldGenTrees(false);
   protected WorldGenBigTree O = new WorldGenBigTree(false);
   protected i P = new i(false);
   protected WorldGenSwamp Q = new WorldGenSwamp();

   protected BiomeGenBase(int par1) {
      this.M = par1;
      a[par1] = this;
      this.I = this.a();
      this.K.add(new bg(cu.class, 12, 4, 4));
      this.K.add(new bg(qr.class, 10, 4, 4));
      this.K.add(new bg(rd.class, 10, 4, 4));
      this.K.add(new bg(un.class, 8, 4, 4));
      this.J.add(new bg(cb.class, 10, 4, 4));
      this.J.add(new bg(EntityZombie.class, 10, 4, 4));
      this.J.add(new bg(EntitySkeleton.class, 10, 4, 4));
      this.J.add(new bg(yd.class, 10, 4, 4));
      this.J.add(new bg(EntitySlime.class, 10, 4, 4));
      this.J.add(new bg(EntityEnderman.class, 1, 1, 4));
   }

   protected BiomeDecorator a() {
      return new BiomeDecorator(this);
   }

   private BiomeGenBase a(float par1, float par2) {
      if (par1 > 0.1F && par1 < 0.2F) {
         throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
      }

      this.F = par1;
      this.G = par2;
      return this;
   }

   private BiomeGenBase b(float par1, float par2) {
      this.D = par1;
      this.E = par2;
      return this;
   }

   private BiomeGenBase m() {
      this.S = false;
      return this;
   }

   public WorldGenerator a(Random par1Random) {
      return par1Random.nextInt(10) == 0 ? this.O : this.N;
   }

   public WorldGenerator b(Random par1Random) {
      return new WorldGenTallGrass(Block.X.bO, 1);
   }

   protected BiomeGenBase b() {
      this.R = true;
      return this;
   }

   protected BiomeGenBase a(String par1Str) {
      this.y = par1Str;
      return this;
   }

   protected BiomeGenBase a(int par1) {
      this.C = par1;
      return this;
   }

   protected BiomeGenBase b(int par1) {
      this.z = par1;
      return this;
   }

   public int a(float par1) {
      par1 /= 3.0F;
      if (par1 < -1.0F) {
         par1 = -1.0F;
      }

      if (par1 > 1.0F) {
         par1 = 1.0F;
      }

      return Color.getHSBColor(0.6222222F - par1 * 0.05F, 0.5F + par1 * 0.1F, 1.0F).getRGB();
   }

   public List a(acf par1EnumCreatureType) {
      if (par1EnumCreatureType == acf.a) {
         return this.J;
      } else {
         return par1EnumCreatureType == acf.b ? this.K : null;
      }
   }

   public boolean c() {
      return this.R;
   }

   public boolean d() {
      return this.R ? false : this.S;
   }

   public boolean e() {
      return this.G > 0.85F;
   }

   public float f() {
      return 0.1F;
   }

   public final int g() {
      return (int)(this.G * 65536.0F);
   }

   public final int h() {
      return (int)(this.F * 65536.0F);
   }

   public final float i() {
      return this.G;
   }

   public final float j() {
      return this.F;
   }

   public void decorate(World par1World, Random par2Random, long par3, long par4) {
      this.I.decorate(par1World, par2Random, par3, par4);
   }

   public int k() {
      double d = MathHelper.a(this.j(), 0.0F, 1.0F);
      double d1 = MathHelper.a(this.i(), 0.0F, 1.0F);
      return zv.a(d, d1);
   }

   public int l() {
      double d = MathHelper.a(this.j(), 0.0F, 1.0F);
      double d1 = MathHelper.a(this.i(), 0.0F, 1.0F);
      return ColorizerFoliage.a(d, d1);
   }
}
