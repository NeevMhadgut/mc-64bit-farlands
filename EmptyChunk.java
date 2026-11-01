import java.util.List;
import java.util.Random;

public class EmptyChunk extends Chunk {
   public EmptyChunk(World par1World, long par2, long par3) {
      super(par1World, par2, par3);
   }

   @Override
   public boolean isAtLocation(long par1, long par2) {
      return par1 == this.g && par2 == this.h;
   }

   @Override
   public int b(int par1, int par2) {
      return 0;
   }

   @Override
   public void a() {
   }

   @Override
   public void b() {
   }

   @Override
   public void c() {
   }

   @Override
   public int a(int par1, int par2, int par3) {
      return 0;
   }

   @Override
   public int b(int par1, int par2, int par3) {
      return 255;
   }

   @Override
   public boolean a(int par1, int par2, int par3, int i, int j) {
      return true;
   }

   @Override
   public boolean a(int par1, int par2, int par3, int i) {
      return true;
   }

   @Override
   public int c(int par1, int par2, int par3) {
      return 0;
   }

   @Override
   public boolean b(int par1, int par2, int par3, int i) {
      return false;
   }

   @Override
   public int a(wl par1EnumSkyBlock, int par2, int par3, int i) {
      return 0;
   }

   @Override
   public void a(wl enumskyblock, int i, int j, int k, int l) {
   }

   @Override
   public int c(int par1, int par2, int par3, int i) {
      return 0;
   }

   @Override
   public void a(Entity entity) {
   }

   @Override
   public void b(Entity entity) {
   }

   @Override
   public void a(Entity entity, int i) {
   }

   @Override
   public boolean d(int par1, int par2, int par3) {
      return false;
   }

   @Override
   public TileEntity e(int par1, int par2, int par3) {
      return null;
   }

   @Override
   public void a(TileEntity tileentity) {
   }

   @Override
   public void a(int i, int j, int k, TileEntity tileentity) {
   }

   @Override
   public void f(int i, int j, int k) {
   }

   @Override
   public void d() {
   }

   @Override
   public void e() {
   }

   @Override
   public void f() {
   }

   @Override
   public void a(Entity entity, AxisAlignedBB axisalignedbb, List list) {
   }

   @Override
   public void a(Class class1, AxisAlignedBB axisalignedbb, List list) {
   }

   @Override
   public boolean a(boolean par1) {
      return false;
   }

   @Override
   public Random a(long par1) {
      return new Random(this.e.v() + this.g * this.g * 4987142L + this.g * 5947611L + this.h * this.h * 4392871L + this.h * 389711L ^ par1);
   }

   @Override
   public boolean g() {
      return true;
   }

   @Override
   public boolean c(int par1, int par2) {
      return true;
   }
}
